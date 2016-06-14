package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class JavaRunner implements CommandVisitor {

    private Memory memory;
    private OutputStream stream;

    public Memory getMemory() {
        return memory;
    }

    public JavaRunner(Memory memory, OutputStream stream) {
        this.memory = memory;
        this.stream = stream;
    }

    public void execute(List<Command> commands) {
        for (Command command : commands) {
            command.accept(this);
        }
    }

    @Override
    public void visit(IncrementCommand command) {
        memory.incrementCellValue(command.getValue());
    }

    @Override
    public void visit(DecrementCommand command) {
        memory.decrementCellValue(command.getValue());
    }

    @Override
    public void visit(PrintCommand command) {
        for (int i = 0; i < command.getValue(); i++) {
            try {
                stream.write((char) memory.getCurrentCellValue());
            } catch (IOException e) {
                throw new IllegalArgumentException("Cannot write given argument to OutputStream!");
            }
        }
    }

    @Override
    public void visit(MovePointerRightCommand command) {
        memory.movePointerToRight(command.getValue());
    }

    @Override
    public void visit(MovePointerLeftCommand command) {
        memory.movePointerToLeft(command.getValue());
    }

    @Override
    public void visit(LoopCommand command) {
        while (memory.getCurrentCellValue() > 0) {
            for (Command innerCommand : command.getCommands()) {
                innerCommand.accept(this);
            }
        }
    }
}
