package ru.kruglov.task14;

import java.io.IOException;
import java.util.logging.*;

public class LoggerExample {
    public static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
    static void loggerConfig() {
        TodayDate date = new TodayDate();
        Handler fileHandler = null;
        Formatter simpleFormatter = null;
        try {
            fileHandler = new FileHandler("./" + date.getTodayDate() + ".log", true);
            simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            LOGGER.addHandler(fileHandler);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Configuration done.");
            LOGGER.setUseParentHandlers(false);
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }
    }
}