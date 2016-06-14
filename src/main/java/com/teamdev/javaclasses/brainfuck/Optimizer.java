package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Optimizer implements CommandVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Optimizer.class);

    private List<Command> optimizedCommands = new ArrayList<>();

    public List<Command> optimize(List<Command> commands) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Commands optimization started");
        }

        for (Command command : commands) {
            command.accept(this);
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Commands optimization finished");
        }

        return optimizedCommands;
    }

    private void visitCommand(AbstractCommand currentCommand) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Checking if commands list is empty");
        }

        if (!optimizedCommands.isEmpty()) {

            final AbstractCommand lastCommand = (AbstractCommand)
                    optimizedCommands.get(optimizedCommands.size() - 1);

            if (currentCommand.getClass().equals(lastCommand.getClass())) {

                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("Optimizing current command: " + currentCommand.getClass());
                }

                lastCommand.setValue(lastCommand.getValue() + 1);

                return;
            }
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Command optimization ended: " + currentCommand.getClass());
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

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Adding new LoopCommand to the list");
        }

        optimizedCommands.add(command);

        final List<Command> justToKeep = optimizedCommands;

        optimizedCommands = new ArrayList<>();

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Optimizing commands in the loop");
        }

        for (Command innerCommand: command.getCommands()) {
            innerCommand.accept(this);
        }

        command.setCommands(optimizedCommands);

        optimizedCommands = justToKeep;

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("LoopCommand optimization ended");
        }

    }
}
