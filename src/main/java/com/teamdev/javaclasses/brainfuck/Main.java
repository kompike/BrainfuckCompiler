package com.teamdev.javaclasses.brainfuck;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final Analyser analyser = new Analyser();
        final List<Command> commands = analyser.parseProgram("++++++++[>++++[>++>+++>+++>+<<<<-]" +
                ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");

        Optimizer optimizer = new Optimizer();
        final List<Command> optimizedList = optimizer.optimize(commands);

        //JavaRunner runner = new JavaRunner(new Memory(100), System.out);
        //runner.execute(optimizedList);

        //JavaGenerator generator = new JavaGenerator(System.out);
        //generator.execute(optimizedList);

        JavaScriptGenerator javaScriptGenerator = new JavaScriptGenerator(System.out);
        javaScriptGenerator.execute(optimizedList);

        /*Main main = new Main();
        main.execute(System.out);*/

    }
}
