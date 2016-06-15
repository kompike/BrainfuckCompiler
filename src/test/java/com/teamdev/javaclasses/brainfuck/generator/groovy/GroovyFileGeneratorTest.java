package com.teamdev.javaclasses.brainfuck.generator.groovy;

import com.teamdev.javaclasses.brainfuck.generator.FileGeneratorUtils;
import freemarker.template.Configuration;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GroovyFileGeneratorTest {

    @Test
    public void testGroovyTemplateCreation() throws Exception {

        createActualFile("package templates;", "src/test/resources/GroovyBrainfuckTranslator.groovy");

        File expected = new File("src/test/resources/templates/GroovyBrainfuckTranslator.groovy");
        File actual = new File("src/test/resources/GroovyBrainfuckTranslator.groovy");

        assertFiles(expected, actual);
    }

    @Test
    public void testGroovyFileOutput() throws Exception {

        createActualFile("package com.teamdev.javaclasses.brainfuck.generator.groovy;",
                "src/main/java/com/teamdev/javaclasses/brainfuck/generator/groovy/GroovyBrainfuckTranslator.groovy");

        final GroovyClassLoader classLoader = new GroovyClassLoader();
        final File file = new File
                ("src/main/java/com/teamdev/javaclasses/brainfuck/generator/groovy/GroovyBrainfuckTranslator.groovy");
        final Class groovyClass = classLoader.parseClass(file);

        final GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        groovyObject.invokeMethod("execute", null);

        assertEquals("", "Hello World!\n", baos.toString());
    }

    private void createActualFile(String pack, String fileDir) {
        FileGeneratorUtils utils = new FileGeneratorUtils();

        final Configuration configuration = utils.getConfiguration("src/main/resources/templates");

        final String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        final GroovyCodeGenerator generator = new GroovyCodeGenerator();
        final String generatedCode = utils.analyzeText(generator, helloWorld);

        final Map<String, String> templateDataMap = new HashMap<>();
        templateDataMap.put("package", pack);
        templateDataMap.put("generatedCode", generatedCode);

        final String templateName = "groovytemplate.ftl";

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