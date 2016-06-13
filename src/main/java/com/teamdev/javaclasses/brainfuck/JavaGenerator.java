package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

public class JavaGenerator implements CommandVisitor {

    private OutputStream stream;

    public JavaGenerator(OutputStream stream) {
        this.stream = stream;
    }

    public void execute(List<Command> commands) {
        try {
            final String methodStart = "public void execute(OutputStream outputStream) {\n" +
                    "\tint[] memory = new int[100];\n" +
                    "\tint pointer = 0;\n";
            stream.write(methodStart.getBytes(Charset.defaultCharset()));
            for (Command command : commands) {
                command.accept(this);
            }
            final String methodEnd = "}";
            stream.write(methodEnd.getBytes(Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(IncrementCommand command) {
        String temp = "\tmemory[pointer]++;\n";
        try {
            if (command.getValue() > 1) {
                String tempWithLoop = "\tfor (int i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
                stream.write(tempWithLoop.getBytes(Charset.defaultCharset()));
            } else {
                stream.write(temp.getBytes(Charset.defaultCharset()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(DecrementCommand command) {
        String temp = "\tmemory[pointer]--;\n";
        try {
            if (command.getValue() > 1) {
                String tempWithLoop = "\tfor (int i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
                stream.write(tempWithLoop.getBytes(Charset.defaultCharset()));
            } else {
                stream.write(temp.getBytes(Charset.defaultCharset()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(PrintCommand command) {
        String temp = "\ttry {\n" +
                "\t\toutputStream.write((char) memory[pointer]);\n" +
                " \t} catch (IOException e) {\n" +
                "\t\tthrow new IllegalStateException(e);\n" +
                "\t}\n";
        try {
            if (command.getValue() > 1) {
                String tempWithLoop = "\tfor (int i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
                stream.write(tempWithLoop.getBytes(Charset.defaultCharset()));
            } else {
                stream.write(temp.getBytes(Charset.defaultCharset()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(MovePointerRightCommand command) {
        String temp = "\tpointer++;\n";
        try {
            if (command.getValue() > 1) {
                String tempWithLoop = "\tfor (int i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
                stream.write(tempWithLoop.getBytes(Charset.defaultCharset()));
            } else {
                stream.write(temp.getBytes(Charset.defaultCharset()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(MovePointerLeftCommand command) {
        String temp = "\tpointer--;\n";
        try {
            if (command.getValue() > 1) {
                String tempWithLoop = "\tfor (int i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
                stream.write(tempWithLoop.getBytes(Charset.defaultCharset()));
            } else {
                stream.write(temp.getBytes(Charset.defaultCharset()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(LoopCommand command) {
        try {
            final String methodStart = "\twhile(memory[pointer] > 0) {\n";
            stream.write(methodStart.getBytes(Charset.defaultCharset()));
            for (Command innerCommand : command.getCommands()) {
                innerCommand.accept(this);
            }

            final String methodEnd = "\t}\n";
            stream.write(methodEnd.getBytes(Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
