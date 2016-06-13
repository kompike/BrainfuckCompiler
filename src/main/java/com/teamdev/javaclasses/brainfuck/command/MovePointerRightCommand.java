package com.teamdev.javaclasses.brainfuck.command;

import com.teamdev.javaclasses.brainfuck.CommandVisitor;

public class MovePointerRightCommand extends AbstractCommand {

    public MovePointerRightCommand() {
    }

    public MovePointerRightCommand(int value) {
        super(value);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

}
