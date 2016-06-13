package com.teamdev.javaclasses.brainfuck;

public interface Command {

    void accept(CommandVisitor visitor);
}
