package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class JavaRunner implements CommandVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaRunner.class);

    private Memory memory;
    private OutputStream stream;

    public Memory getMemory() {
        return memory;
    }

    public JavaRunner(Memory memory, OutputStream stream) {
        this.memory = memory;
        this.stream = stream;
    }

    public void execute(List<Command> commands) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Commands executing started");
        }

        for (Command command : commands) {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Executing command: " + command.getClass().getSimpleName());
            }

            command.accept(this);
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Commands executing finished");
        }
    }

    @Override
    public void visit(IncrementCommand command) {
        memory.incrementCellValue(command.getValue());
    }

    @Override
    public void visit(DecrementCommand command) {
        memory.decrementCellValue(command.getValue());
    }

    @Override
    public void visit(PrintCommand command) {
        for (int i = 0; i < command.getValue(); i++) {
            try {
                stream.write((char) memory.getCurrentCellValue());
            } catch (IOException e) {
                throw new IllegalArgumentException("Cannot write given argument to OutputStream!");
            }
        }
    }

    @Override
    public void visit(MovePointerRightCommand command) {
        memory.movePointerToRight(command.getValue());
    }

    @Override
    public void visit(MovePointerLeftCommand command) {
        memory.movePointerToLeft(command.getValue());
    }

    @Override
    public void visit(LoopCommand command) {
        while (memory.getCurrentCellValue() > 0) {

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Running commands in the loop");
            }

            for (Command innerCommand : command.getCommands()) {
                innerCommand.accept(this);
            }

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("LoopCommand executing ended");
            }
        }
    }
}
