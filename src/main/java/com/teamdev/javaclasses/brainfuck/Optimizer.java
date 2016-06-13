package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;

import java.util.ArrayList;
import java.util.List;

public class Optimizer implements CommandVisitor {

    private List<Command> optimizedCommands = new ArrayList<>();

    public List<Command> optimize(List<Command> commands) {
        for (Command command : commands) {
            command.accept(this);
        }

        return optimizedCommands;
    }

    private void visitCommand(AbstractCommand currentCommand) {
        if (!optimizedCommands.isEmpty()) {

            final AbstractCommand lastCommand = (AbstractCommand)
                    optimizedCommands.get(optimizedCommands.size() - 1);

            if (currentCommand.getClass().equals(lastCommand.getClass())) {

                lastCommand.setValue(lastCommand.getValue() + 1);

                return;
            }
        }

        optimizedCommands.add(currentCommand);
    }

    @Override
    public void visit(IncrementCommand command) {
        visitCommand(command);
    }

    @Override
    public void visit(DecrementCommand command) {
        visitCommand(command);
    }

    @Override
    public void visit(PrintCommand command) {
        visitCommand(command);
    }

    @Override
    public void visit(MovePointerRightCommand command) {
        visitCommand(command);
    }

    @Override
    public void visit(MovePointerLeftCommand command) {
        visitCommand(command);
    }

    @Override
    public void visit(LoopCommand command) {

        optimizedCommands.add(command);

        final List<Command> justToKeep = optimizedCommands;

        optimizedCommands = new ArrayList<>();

        for (Command innerCommand: command.getCommands()) {
            innerCommand.accept(this);
        }

        command.setCommands(optimizedCommands);

        optimizedCommands = justToKeep;

    }
}
