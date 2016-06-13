package com.teamdev.javaclasses.brainfuck.command;

import com.teamdev.javaclasses.brainfuck.Command;

public abstract class AbstractCommand implements Command {

    private int value = 1;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AbstractCommand() {
    }

    public AbstractCommand(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCommand)) return false;

        AbstractCommand that = (AbstractCommand) o;

        return getValue() == that.getValue();

    }

    @Override
    public int hashCode() {
        return getValue();
    }
}
