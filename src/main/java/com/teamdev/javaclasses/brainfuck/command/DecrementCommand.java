package com.teamdev.javaclasses.brainfuck.command;

import com.teamdev.javaclasses.brainfuck.CommandVisitor;

public class DecrementCommand extends AbstractCommand {

    public DecrementCommand() {
    }

    public DecrementCommand(int value) {
        super(value);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
