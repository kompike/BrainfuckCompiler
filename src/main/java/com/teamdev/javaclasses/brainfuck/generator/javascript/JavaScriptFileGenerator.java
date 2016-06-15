package com.teamdev.javaclasses.brainfuck.generator.javascript;

import com.teamdev.javaclasses.brainfuck.generator.FileGeneratorUtils;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;

public class JavaScriptFileGenerator {

    public static void main(String[] args) {

        FileGeneratorUtils utils = new FileGeneratorUtils();

        final Configuration configuration = utils.getConfiguration("src/main/resources/templates");

        final String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        final  JavaScriptCodeGenerator generator = new JavaScriptCodeGenerator();
        final String generatedCode = utils.analyzeText(generator, helloWorld);

        final Map<String, String> templateDataMap = new HashMap<>();
        templateDataMap.put("function", generatedCode);

        final String templateName = "jstemplate.ftl";
        final String fileDir =
                "src/main/resources/hello.html";

        utils.createFile(configuration, templateDataMap, fileDir, templateName);
    }

}
