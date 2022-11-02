package exercise.task2;

import exercise.task2.appenders.Appender;
import exercise.task2.appenders.ConsoleAppender;
import exercise.task2.appenders.FileAppender;
import exercise.task2.layouts.Layout;
import exercise.task2.layouts.SimpleLayout;
import exercise.task2.loggers.Logger;
import exercise.task2.loggers.MessageLogger;
import exercise.task2.utilities.File;
import exercise.task2.utilities.LogFile;

public class Controller {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout, file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
    }
}
