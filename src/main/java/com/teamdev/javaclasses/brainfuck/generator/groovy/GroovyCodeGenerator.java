package com.teamdev.javaclasses.brainfuck.generator.groovy;

import com.teamdev.javaclasses.brainfuck.Command;
import com.teamdev.javaclasses.brainfuck.command.*;
import com.teamdev.javaclasses.brainfuck.generator.CodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GroovyCodeGenerator implements CodeGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroovyCodeGenerator.class);

    private StringBuilder builder = new StringBuilder("");

    @Override
    public String execute(List<Command> commands) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Commands executing started");
        }

        for (Command command : commands) {

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Executing command: " + command.getClass());
            }

            command.accept(this);
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Commands executing finished");
        }

        return builder.toString();
    }

    @Override
    public void visit(IncrementCommand command) {
        for (int i = 0; i < command.getValue(); i++) {
            builder.append("\tmemory[pointer]++\n");
        }
    }

    @Override
    public void visit(DecrementCommand command) {
        for (int i = 0; i < command.getValue(); i++) {
            builder.append("\tmemory[pointer]--\n");
        }
    }

    @Override
    public void visit(PrintCommand command) {
        for (int i = 0; i < command.getValue(); i++) {
            builder.append("\tprint ((char) memory[pointer])\n");
        }
    }

    @Override
    public void visit(MovePointerRightCommand command) {
        for (int i = 0; i < command.getValue(); i++) {
            builder.append("\tpointer++\n");
        }
    }

    @Override
    public void visit(MovePointerLeftCommand command) {
        for (int i = 0; i < command.getValue(); i++) {
            builder.append("\tpointer--\n");
        }
    }

    @Override
    public void visit(LoopCommand command) {
        final String methodStart = "\twhile(memory[pointer] > 0) {\n";
        builder.append(methodStart);
        for (Command innerCommand : command.getCommands()) {
            innerCommand.accept(this);
        }

        final String methodEnd = "}\n";
        builder.append(methodEnd);
    }

}
