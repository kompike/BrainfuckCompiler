package com.teamdev.javaclasses.brainfuck.generator.javascript;

import com.teamdev.javaclasses.brainfuck.generator.TemplateGeneratorUtils;
import freemarker.template.Configuration;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JavaScriptTemplateGeneratorTest {

    @Test
    public void testJavaScriptTemplateCreation() throws Exception {

        createActualFile();

        File expected = new File("src/test/resources/templates/JavaScriptBrainfuckTemplate.html");
        File actual = new File("src/test/resources/JavaScriptBrainfuckTemplate.html");

        assertFiles(expected, actual);
    }

    private void createActualFile() {
        TemplateGeneratorUtils utils = new TemplateGeneratorUtils();

        final Configuration configuration = utils.getConfiguration("src/main/resources/templates");

        final String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        final JavaScriptCodeGenerator generator = new JavaScriptCodeGenerator();
        final String generatedCode = utils.analyzeText(generator, helloWorld);

        final Map<String, String> templateDataMap = new HashMap<>();
        templateDataMap.put("function", generatedCode);

        final String templateName = "jstemplate.ftl";
        final String fileDir =
                "src/test/resources/JavaScriptBrainfuckTemplate.html";

        utils.createFile(configuration, templateDataMap, fileDir, templateName);
    }

    private void assertFiles(File expected, File actual) throws IOException {

        BufferedReader expectedReader = new BufferedReader(new FileReader(expected));
        BufferedReader actualReader = new BufferedReader(new FileReader(actual));

        String expectedLine;

        while ((expectedLine = expectedReader.readLine()) != null) {
            assertEquals("Compared files do not match!", expectedLine, actualReader.readLine());
        }

    }
}