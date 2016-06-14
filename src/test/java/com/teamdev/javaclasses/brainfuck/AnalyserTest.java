package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnalyserTest {

    private final Analyser ANALYSER = new Analyser();

    @Test
    public void testAnalyseIncrementCommand() {

        final List<Command> commands = ANALYSER.parseProgram("+");

        assertCommandList(Collections.singletonList(new IncrementCommand()), commands);
    }
    @Test
    public void testAnalyseDecrementCommand() {

        final List<Command> commands = ANALYSER.parseProgram("-");

        assertCommandList(Collections.singletonList(new DecrementCommand()), commands);
    }
    @Test
    public void testAnalysePrintCommand() {

        final List<Command> commands = ANALYSER.parseProgram("..");

        assertCommandList(Arrays.asList(new PrintCommand(), new PrintCommand()), commands);
    }
    @Test
    public void testAnalyseMovePointerToRightCommand() {

        final List<Command> commands = ANALYSER.parseProgram(">>");

        assertCommandList(Arrays.asList(new MovePointerRightCommand(), new MovePointerRightCommand()), commands);
    }
    @Test
    public void testAnalyseMovePointerToLeftCommand() {

        final List<Command> commands = ANALYSER.parseProgram("<<");

        assertCommandList(Arrays.asList(new MovePointerLeftCommand(), new MovePointerLeftCommand()), commands);
    }

    @Test
    public void testAnalyseNestedLoops() {

        final List<Command> commands = ANALYSER.parseProgram("[[][]]");

        assertCommandList(Collections.singletonList(
                new LoopCommand(Arrays.asList(new LoopCommand(Collections.emptyList()),
                        new LoopCommand(Collections.emptyList())))), commands);

    }

    @Test
    public void testAnalyseLoops() {

        final List<Command> commands = ANALYSER.parseProgram("[]");

        assertCommandList(Collections.singletonList(
                new LoopCommand(Collections.emptyList())), commands);

    }

    private void assertCommandList(List<Command> expectedCommands, List<Command> actualCommands) {

        Assert.assertEquals("Compared lists have different size!", expectedCommands.size(), actualCommands.size());

        Assert.assertEquals("Compared lists are not equals!", expectedCommands, actualCommands);

    }

}