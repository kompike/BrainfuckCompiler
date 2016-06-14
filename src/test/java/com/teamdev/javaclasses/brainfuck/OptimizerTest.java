package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class OptimizerTest {

    @Test
    public void testIncrementCommandOptimization() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new IncrementCommand());
        commands.add(new IncrementCommand());

        final List<Command> optimizedList =
                new Optimizer().optimize(commands);

        assertCommandList(singletonList(
                new IncrementCommand(2)),
                optimizedList);
    }

    @Test
    public void testDecrementCommandOptimization() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new DecrementCommand());
        commands.add(new DecrementCommand());

        final List<Command> optimizedList =
                new Optimizer().optimize(commands);

        assertCommandList(singletonList(
                new DecrementCommand(2)),
                optimizedList);
    }

    @Test
    public void testPrintCommandOptimization() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new PrintCommand());
        commands.add(new PrintCommand());

        final List<Command> optimizedList =
                new Optimizer().optimize(commands);

        assertCommandList(singletonList(
                new PrintCommand(2)),
                optimizedList);
    }

    @Test
    public void testMovePointerRightCommandOptimization() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerRightCommand());
        commands.add(new MovePointerRightCommand());

        final List<Command> optimizedList =
                new Optimizer().optimize(commands);

        assertCommandList(singletonList(
                new MovePointerRightCommand(2)),
                optimizedList);
    }

    @Test
    public void testMovePointerLeftCommandOptimization() {

        final List<Command> commands = new ArrayList<>();
        commands.add(new MovePointerLeftCommand());
        commands.add(new MovePointerLeftCommand());

        final List<Command> optimizedList =
                new Optimizer().optimize(commands);

        assertCommandList(singletonList(
                new MovePointerLeftCommand(2)),
                optimizedList);
    }

    @Test
    public void testLoopCommandOptimization() {

        final List<Command> commands = new ArrayList<>();
        final List<Command> incrementCommands = new ArrayList<>();
        incrementCommands.add(new IncrementCommand());
        incrementCommands.add(new IncrementCommand());
        commands.add(new LoopCommand(incrementCommands));

        final List<Command> optimizedList =
                new Optimizer().optimize(commands);

        assertCommandList(singletonList(new LoopCommand
                (singletonList(new IncrementCommand(2)))), optimizedList);
    }


    private void assertCommandList(List<Command> expectedCommands, List<Command> actualCommands) {

        assertEquals("Compared lists have different size!", expectedCommands.size(), actualCommands.size());
        assertEquals("Compared lists are not equals!", expectedCommands, actualCommands);

    }

}