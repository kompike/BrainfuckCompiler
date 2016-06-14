package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JavaRunnerTest {

    private final JavaRunner runner = new JavaRunner(new Memory(100), System.out);

    @Test
    public void testIncrementCommandRunner() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new IncrementCommand(2));
        commands.add(new IncrementCommand(3));

        runner.execute(commands);

        assertEquals("Current cell value does not match!", 5, runner.getMemory().getCurrentCellValue());
    }

    @Test
    public void testDecrementCommandRunner() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new IncrementCommand(3));
        commands.add(new DecrementCommand(2));

        runner.execute(commands);

        assertEquals("Current cell value does not match!", 1, runner.getMemory().getCurrentCellValue());
    }

    @Test
    public void testPrintCommandRunner() {

        final OutputStream stream = new ByteArrayOutputStream();
        final JavaRunner javaRunner = new JavaRunner(new Memory(10), stream);

        final List<Command> commands = new ArrayList<>();
        commands.add(new IncrementCommand(65));
        commands.add(new PrintCommand());

        javaRunner.execute(commands);

        assertEquals("Printed value does not match!", 'A', stream.toString().toCharArray()[0]);
    }

    @Test
    public void testMovePointerRightCommandRunner() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand(2));

        runner.execute(commands);

        assertEquals("Pointer value does not match!", 2, runner.getMemory().getPointer());
    }

    @Test
    public void testMovePointerLeftCommandRunner() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand(3));
        commands.add(new MovePointerLeftCommand(2));

        runner.execute(commands);

        assertEquals("Pointer value does not match!", 1, runner.getMemory().getPointer());
    }

    @Test
    public void testLoopCommandRunner() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand());
        commands.add(new IncrementCommand(2));
        commands.add(new MovePointerLeftCommand());
        commands.add(new DecrementCommand());

        final List<Command> loopCommands = new ArrayList<>();
        loopCommands.add(new IncrementCommand(2));
        loopCommands.add(new LoopCommand(commands));
        loopCommands.add(new MovePointerRightCommand());

        runner.execute(loopCommands);

        assertEquals("Current cell value does not match!", 4, runner.getMemory().getCurrentCellValue());
    }

}