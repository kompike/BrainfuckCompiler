package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.command.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

public class JavaScriptGenerator implements CommandVisitor {

    private OutputStream stream;

    public JavaScriptGenerator(OutputStream stream) {
        this.stream = stream;
    }

    public void execute(List<Command> commands) {
        try {
            final String methodStart = "function execute() {\n" +
                    "\tvar memory = new Array(100);\n" +
                    "\tvar pointer = 0;\n " +
                    "\tvar result = '';\n " +
                    "for (var i=0; i < memory.length; i++){\n" +
                    "\t\tmemory[i] = 0;\n" +
                    "\t}";
            stream.write(methodStart.getBytes(Charset.defaultCharset()));
            for (Command command : commands) {
                command.accept(this);
            }
            final String methodEnd = "console.log(result);\n}";
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
                String tempWithLoop = "\tfor (var i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
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
                String tempWithLoop = "\tfor (var i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
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
        String temp = "\tresult += String.fromCharCode(memory[pointer]);\n";
        try {
            if (command.getValue() > 1) {
                String tempWithLoop = "\tfor (var i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
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
                String tempWithLoop = "\tfor (var i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
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
                String tempWithLoop = "\tfor (var i = 0; i < " + command.getValue() + "; i++) {\n\t" + temp + "\t}\n";
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

