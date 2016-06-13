package com.teamdev.javaclasses.brainfuck.command;

import com.teamdev.javaclasses.brainfuck.CommandVisitor;

public class IncrementCommand extends AbstractCommand {

    public IncrementCommand() {
    }

    public IncrementCommand(int value) {
        super(value);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
