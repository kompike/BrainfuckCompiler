package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;

import java.util.*;

public class Analyser {

        public List<Command> parseProgram(String program) {

            if (program == null || program.trim().isEmpty()) {
                throw new IllegalArgumentException("Program is empty");
            }

            final Deque<List<Command>> stack = new ArrayDeque<>();

            stack.push(new ArrayList<>());

            for (char commandSymbol : program.toCharArray()) {

                switch (commandSymbol) {

                    case '+':
                        stack.peek().add(new IncrementCommand());
                        break;

                    case '-':
                        stack.peek().add(new DecrementCommand());
                        break;

                    case '>':
                        stack.peek().add(new MovePointerRightCommand());
                        break;

                    case '<':
                        stack.peek().add(new MovePointerLeftCommand());
                        break;

                    case '.':
                        stack.peek().add(new PrintCommand());
                        break;

                    case '[':
                        stack.push(new ArrayList<>());
                        break;

                    case ']':

                        if (stack.size() < 2) {
                            throw new IllegalStateException("Start loop not found!");
                        }

                        LoopCommand loopCommand = new LoopCommand(stack.pop());
                        stack.peek().add(loopCommand);
                        break;

                    default:
                        throw new IllegalArgumentException("Unknown command");

                }

            }

            if (stack.size() > 1) {

                throw new IllegalStateException("Some loop is not closed!");

            }

            return stack.pop();
        }

}
