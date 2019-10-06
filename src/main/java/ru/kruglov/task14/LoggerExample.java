package ru.kruglov.task14;

import java.io.IOException;
import java.util.logging.*;

public class LoggerExample {
    public static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
    public static void loggerConfig() {
        TodayDate date = new TodayDate();
        Handler fileHandler = null;
        Formatter simpleFormatter = null;
        try {
            //Creating consoleHandler and fileHandler
            fileHandler = new FileHandler("./" + date.getTodayDate() + ".log");
            simpleFormatter = new SimpleFormatter();
            //Assigning handlers to LOGGER object
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(simpleFormatter);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Configuration done.");
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }
    }
}