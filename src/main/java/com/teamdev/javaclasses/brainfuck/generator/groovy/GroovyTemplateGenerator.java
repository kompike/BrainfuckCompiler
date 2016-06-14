package com.teamdev.javaclasses.brainfuck.generator.groovy;

import com.teamdev.javaclasses.brainfuck.generator.TemplateGeneratorUtils;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;

public class GroovyTemplateGenerator {

    public static void main(String[] args) {

        TemplateGeneratorUtils utils = new TemplateGeneratorUtils();

        final Configuration configuration = utils.getConfiguration("src/main/resources/templates");

        final String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        final GroovyCodeGenerator generator = new GroovyCodeGenerator();
        final String generatedCode = utils.analyzeText(generator, helloWorld);

        final Map<String, String> templateDataMap = new HashMap<>();
        templateDataMap.put("package", "package com.teamdev.javaclasses.brainfuck.generator.groovy;");
        templateDataMap.put("generatedCode", generatedCode);

        final String templateName = "groovytemplate.ftl";
        final String fileDir =
                "src/main/java/com/teamdev/javaclasses/brainfuck/generator/groovy/GroovyBrainfuckTranslator.groovy";

        utils.createFile(configuration, templateDataMap, fileDir, templateName);
    }

}