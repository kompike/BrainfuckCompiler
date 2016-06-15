package com.teamdev.javaclasses.brainfuck;

import com.teamdev.javaclasses.brainfuck.generator.groovy.GroovyCodeGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.groovy.GroovyFileGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.java.JavaCodeGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.java.JavaFileGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.javascript.JavaScriptCodeGeneratorTest;
import com.teamdev.javaclasses.brainfuck.generator.javascript.JavaScriptFileGeneratorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AnalyserTest.class, GroovyCodeGeneratorTest.class, GroovyFileGeneratorTest.class,
        JavaCodeGeneratorTest.class, JavaRunnerTest.class, JavaScriptCodeGeneratorTest.class,
        JavaScriptFileGeneratorTest.class, JavaFileGeneratorTest.class, MemoryTest.class, OptimizerTest.class})
public class BrainfuckCompilerTest {

}
