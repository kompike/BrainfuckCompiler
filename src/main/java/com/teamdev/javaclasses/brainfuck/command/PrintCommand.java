package com.teamdev.javaclasses.brainfuck.command;

import com.teamdev.javaclasses.brainfuck.CommandVisitor;

public class PrintCommand extends AbstractCommand {

    public PrintCommand() {
    }

    public PrintCommand(int value) {
        super(value);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

}
