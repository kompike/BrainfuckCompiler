package com.teamdev.javaclasses.brainfuck.generator.java;

import com.teamdev.javaclasses.brainfuck.generator.FileGeneratorUtils;
import freemarker.template.Configuration;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JavaFileGeneratorTest {

    @Test
    public void testJavaTemplateCreation() throws Exception {

        createActualFile();

        File expected = new File("src/test/resources/templates/JavaBrainfuckTranslator.java");
        File actual = new File("src/test/resources/JavaBrainfuckTranslator.java");

        assertFiles(expected, actual);
    }

    private void createActualFile() {
        FileGeneratorUtils utils = new FileGeneratorUtils();

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
                "src/test/resources/JavaBrainfuckTranslator.java";

        utils.createFile(configuration, templateDataMap, fileDir, templateName);
    }

    private void assertFiles(File expected, File actual) throws IOException {

        BufferedReader expectedReader = new BufferedReader(new FileReader(expected));
        BufferedReader actualReader = new BufferedReader(new FileReader(actual));

        String expectedLine;

        while ((expectedLine = expectedReader.readLine()) != null) {
            assertEquals("Compared files do not match!", expectedLine, actualReader.readLine());
        }

        assertNull("Actual file has lines!", actualReader.readLine());

    }
}