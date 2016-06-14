package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.generator.groovy.GroovyCodeGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.groovy.GroovyTemplateGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.java.JavaCodeGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.java.JavaTemplateGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.javascript.JavaScriptCodeGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.javascript.JavaScriptTemplateGeneratorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AnalyserTest.class, GroovyCodeGeneratorTest.class, GroovyTemplateGeneratorTest.class,
        JavaCodeGeneratorTest.class, JavaRunnerTest.class, JavaScriptCodeGeneratorTest.class,
        JavaScriptTemplateGeneratorTest.class, JavaTemplateGeneratorTest.class, MemoryTest.class, OptimizerTest.class})
public class BrainfuckCompilerTest {

}
