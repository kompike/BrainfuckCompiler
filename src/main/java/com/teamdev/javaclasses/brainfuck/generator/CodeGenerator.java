package com.teamdev.javaclasses.brainfuck.generator;

import com.teamdev.javaclasses.brainfuck.Command;
import com.teamdev.javaclasses.brainfuck.CommandVisitor;

import java.util.List;

public interface CodeGenerator extends CommandVisitor {

    String execute(List<Command> commands);

}
