package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.IncrementCommand;
import com.teamdev.javaclasses.brainfuck.command.LoopCommand;
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

        Assert.assertEquals("", expectedCommands.size(), actualCommands.size());

        Assert.assertEquals("", expectedCommands, actualCommands);

    }

}