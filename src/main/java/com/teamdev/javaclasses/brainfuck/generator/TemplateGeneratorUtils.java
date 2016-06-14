package com.teamdev.javaclasses.brainfuck.generator;

import com.teamdev.javaclasses.brainfuck.Analyser;
import com.teamdev.javaclasses.brainfuck.Command;
import com.teamdev.javaclasses.brainfuck.Optimizer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class TemplateGeneratorUtils {

    public Writer createFile(Configuration configuration, Map<String, String> map, String fileDir, String templateName) {
        final Template template;
        Writer file = null;

        try {
            template = configuration.getTemplate(templateName);
            file = new FileWriter(new File(fileDir));
            template.process(map, file);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot create file!");
        } catch (TemplateException e) {
            throw new IllegalArgumentException("Template with such name not found!");
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    throw new IllegalStateException("File not found!");
                }
            }
        }

        return file;
    }

    public Configuration getConfiguration(String templateDir) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        try {
            configuration.setDirectoryForTemplateLoading(new File(templateDir));
        } catch (IOException e) {
            throw new IllegalStateException("Needed directory not found!");
        }
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);

        return configuration;
    }

    public String analyzeText(CodeGenerator generator, String text) {

        final Analyser analyser = new Analyser();
        final List<Command> commands = analyser.parseProgram(text);

        final Optimizer optimizer = new Optimizer();
        final List<Command> optimizedList = optimizer.optimize(commands);

        return generator.execute(optimizedList);
    }

}
