package com.teamdev.javaclasses.brainfuck.generator.groovy;

import com.teamdev.javaclasses.brainfuck.Command;
import com.teamdev.javaclasses.brainfuck.command.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GroovyCodeGeneratorTest {

    private final GroovyCodeGenerator generator = new GroovyCodeGenerator();

    @Test
    public void testIncrementCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new IncrementCommand());

        assertEquals("Obtain text value does not equals 'memory[pointer]++'",
                "\tmemory[pointer]++\n", generator.execute(commands));
    }

    @Test
    public void testDecrementCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new DecrementCommand());

        assertEquals("Obtain text value does not equals 'memory[pointer]--'",
                "\tmemory[pointer]--\n", generator.execute(commands));
    }

    @Test
    public void testPrintCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new PrintCommand());

        assertEquals("Obtain text value does not equals 'print ((char) memory[pointer])'",
                "\tprint ((char) memory[pointer])\n", generator.execute(commands));
    }

    @Test
    public void testMovePointerRightCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand());

        assertEquals("Obtain text value does not equals 'pointer++'",
                "\tpointer++\n", generator.execute(commands));
    }

    @Test
    public void testMovePointerLeftCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerLeftCommand());

        assertEquals("Obtain text value does not equals 'pointer--'",
                "\tpointer--\n", generator.execute(commands));
    }

    @Test
    public void testLoopCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand());

        final List<Command> loopCommands = new ArrayList<>();
        loopCommands.add(new LoopCommand(commands));

        assertEquals("Obtain text value does not equals 'while(memory[pointer] > 0) {pointer++}'",
                "\twhile(memory[pointer] > 0) {\n\tpointer++\n}\n", generator.execute(loopCommands));
    }


}