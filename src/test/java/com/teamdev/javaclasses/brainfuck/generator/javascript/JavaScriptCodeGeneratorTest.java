package com.teamdev.javaclasses.brainfuck.generator.javascript;

import com.teamdev.javaclasses.brainfuck.Command;
import com.teamdev.javaclasses.brainfuck.command.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JavaScriptCodeGeneratorTest {

    private final JavaScriptCodeGenerator generator = new JavaScriptCodeGenerator();
    private final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Test
    public void testIncrementCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new IncrementCommand());

        assertEquals("Obtain text value does not equals 'memory[pointer]++;'",
                "\tmemory[pointer]++;" + LINE_SEPARATOR, generator.execute(commands));
    }

    @Test
    public void testDecrementCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new DecrementCommand());

        assertEquals("Obtain text value does not equals 'memory[pointer]--;'",
                "\tmemory[pointer]--;" + LINE_SEPARATOR, generator.execute(commands));
    }

    @Test
    public void testPrintCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new PrintCommand());

        assertEquals("Obtain text value does not equals 'result += String.fromCharCode(memory[pointer]);'",
                "\tresult += String.fromCharCode(memory[pointer]);" + LINE_SEPARATOR, generator.execute(commands));
    }

    @Test
    public void testMovePointerRightCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand());

        assertEquals("Obtain text value does not equals 'pointer++;'", "\tpointer++;" + LINE_SEPARATOR,
                generator.execute(commands));
    }

    @Test
    public void testMovePointerLeftCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerLeftCommand());

        assertEquals("Obtain text value does not equals 'pointer--;'",
                "\tpointer--;" + LINE_SEPARATOR, generator.execute(commands));
    }

    @Test
    public void testLoopCommandGenerator() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand());

        final List<Command> loopCommands = new ArrayList<>();
        loopCommands.add(new LoopCommand(commands));

        assertEquals("Obtain text value does not equals 'while(memory[pointer] > 0) {pointer++;}'",
                "\twhile(memory[pointer] > 0) {" + LINE_SEPARATOR + "\tpointer++;" + LINE_SEPARATOR +"\t}"
                        + LINE_SEPARATOR, generator.execute(loopCommands));
    }


}