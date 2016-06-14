package com.teamdev.javaclasses.brainfuck.generator.java;

import com.teamdev.javaclasses.brainfuck.generator.TemplateGeneratorUtils;
import freemarker.template.Configuration;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JavaTemplateGeneratorTest {

    @Test
    public void testJavaTemplateCreation() throws Exception {

        createActualFile();

        File expected = new File("src/test/resources/templates/JavaBrainfuckTemplate.java");
        File actual = new File("src/test/resources/JavaBrainfuckTemplate.java");

        assertFiles(expected, actual);
    }

    private void createActualFile() {
        TemplateGeneratorUtils utils = new TemplateGeneratorUtils();

        final Configuration configuration = utils.getConfiguration("src/main/resources/templates");

        final String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        final JavaCodeGenerator generator = new JavaCodeGenerator();
        final String generatedCode = utils.analyzeText(generator, helloWorld);

        final Map<String, String> templateDataMap = new HashMap<>();
        templateDataMap.put("package", "package templates;");
        templateDataMap.put("generatedCode", generatedCode);

        final String templateName = "javatemplate.ftl";
        final String fileDir =
                "src/test/resources/JavaBrainfuckTemplate.java";

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