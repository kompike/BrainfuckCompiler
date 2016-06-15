package com.teamdev.javaclasses.brainfuck.generator.java;

import com.teamdev.javaclasses.brainfuck.generator.FileGeneratorUtils;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;

public class JavaFileGenerator {

    public static void main(String[] args) {

        FileGeneratorUtils utils = new FileGeneratorUtils();

        final Configuration configuration = utils.getConfiguration("src/main/resources/templates");

        final String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        final JavaCodeGenerator generator = new JavaCodeGenerator();
        final String generatedCode = utils.analyzeText(generator, helloWorld);

        final Map<String, String> templateDataMap = new HashMap<>();
        templateDataMap.put("package", "package com.teamdev.javaclasses.brainfuck.generator;");
        templateDataMap.put("generatedCode", generatedCode);

        final String templateName = "javatemplate.ftl";
        final String fileDir =
                "src/main/java/com/teamdev/javaclasses/brainfuck/generator/java/JavaBrainfuckTranslator.java";

        utils.createFile(configuration, templateDataMap, fileDir, templateName);
    }

}
