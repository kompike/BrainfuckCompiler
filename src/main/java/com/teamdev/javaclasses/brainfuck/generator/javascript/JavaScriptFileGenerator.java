package com.teamdev.javaclasses.brainfuck.generator.javascript;

import com.teamdev.javaclasses.brainfuck.generator.FileGeneratorUtils;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;

public class JavaScriptFileGenerator {

    public static void main(String[] args) {

        final String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        final String templateName = "jstemplate.ftl";
        final String fileDir = "src/main/resources/hello.html";

        final FileGeneratorUtils utils = new FileGeneratorUtils();

        final Configuration configuration = utils.getConfiguration("src/main/resources/templates");

        final String generatedCode = utils.analyzeText(new JavaScriptCodeGenerator(), helloWorld);

        final Map<String, String> templateDataMap = new HashMap<>();
        templateDataMap.put("function", generatedCode);

        utils.createFile(configuration, templateDataMap, fileDir, templateName);
    }

}
