package com.teamdev.javaclasses.brainfuck.generator;

import com.teamdev.javaclasses.brainfuck.Analyser;
import com.teamdev.javaclasses.brainfuck.Command;
import com.teamdev.javaclasses.brainfuck.Optimizer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class TemplateGeneratorUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateGeneratorUtils.class);

    public Writer createFile(Configuration configuration, Map<String, String> map, String fileDir, String templateName) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("File creation started");
        }

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

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Commands optimization ended");
        }

        return file;
    }

    public Configuration getConfiguration(String templateDir) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Getting freemarker configuration");
        }

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        try {
            configuration.setDirectoryForTemplateLoading(new File(templateDir));
        } catch (IOException e) {
            throw new IllegalStateException("Needed directory not found!");
        }
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Configuration is ready");
        }

        return configuration;
    }

    public String analyzeText(CodeGenerator generator, String text) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Analyzing and optimizing text");
        }

        final Analyser analyser = new Analyser();
        final List<Command> commands = analyser.parseProgram(text);

        final Optimizer optimizer = new Optimizer();
        final List<Command> optimizedList = optimizer.optimize(commands);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Text analysis and optimization ended");
        }

        return generator.execute(optimizedList);
    }

}
