package exercise.task2;

import exercise.task2.appenders.Appender;
import exercise.task2.appenders.ConsoleAppender;
import exercise.task2.layouts.Layout;
import exercise.task2.layouts.SimpleLayout;
import exercise.task2.loggers.Logger;
import exercise.task2.loggers.MessageLogger;

public class Controller {
    public static void main(String[] args) {
        Layout layout = new SimpleLayout();
        Appender appender = new ConsoleAppender(layout);
        Logger logger = new MessageLogger(appender);

        logger.logInfo("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logWarning("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logCritical("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logFatal("3/26/2015 2:08:11 PM", "Error parsing JSON.");
    }
}
