package com.teamdev.javaclasses.brainfuck.command;

import com.teamdev.javaclasses.brainfuck.CommandVisitor;

public class MovePointerLeftCommand extends AbstractCommand {

    public MovePointerLeftCommand() {
    }

    public MovePointerLeftCommand(int value) {
        super(value);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
