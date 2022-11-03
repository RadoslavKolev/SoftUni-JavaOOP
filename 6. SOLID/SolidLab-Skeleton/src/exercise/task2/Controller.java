package exercise.task2;

import exercise.task2.appenders.Appender;
import exercise.task2.appenders.ConsoleAppender;
import exercise.task2.appenders.FileAppender;
import exercise.task2.enums.LogLevel;
import exercise.task2.layouts.Layout;
import exercise.task2.layouts.SimpleLayout;
import exercise.task2.layouts.XmlLayout;
import exercise.task2.loggers.Logger;
import exercise.task2.loggers.MessageLogger;
import exercise.task2.utilities.LogFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Appender, LogLevel> appendersMap = new LinkedHashMap<>();
        fillMap(scanner, appendersMap);

        Logger logger = new MessageLogger(appendersMap);
        logMessages(scanner, logger);
        System.out.println(logger);
    }

    private static void fillMap(Scanner scanner, Map<Appender, LogLevel> appendersMap) {
        int appendersCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < appendersCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String appenderType = tokens[0];
            String layoutType = tokens[1];

            LogLevel level = tokens.length == 3
                    ? LogLevel.valueOf(tokens[2])
                    : LogLevel.INFO;

            Layout layout = createLayout(layoutType);
            Appender appender = createAppender(appenderType, layout);

            appendersMap.put(appender, level);
        }
    }

    private static Layout createLayout(String layoutType) {
        return layoutType.equals("SimpleLayout")
                ? new SimpleLayout()
                : new XmlLayout();
    }

    private static Appender createAppender(String appenderType, Layout layout) {
        return appenderType.equals("ConsoleAppender")
                ? new ConsoleAppender(layout)
                : new FileAppender(layout, new LogFile());
    }

    private static void logMessages(Scanner scanner, Logger logger) {
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\|");

            LogLevel level = LogLevel.valueOf(tokens[0]);
            String timeStamp = tokens[1];
            String message = tokens[2];

            switch (level) {
                case INFO -> logger.logInfo(timeStamp, message);
                case WARNING -> logger.logWarning(timeStamp, message);
                case ERROR -> logger.logError(timeStamp, message);
                case CRITICAL -> logger.logCritical(timeStamp, message);
                case FATAL -> logger.logFatal(timeStamp, message);
            }

            input = scanner.nextLine();
        }
    }
}

/*
Input:
    2
    ConsoleAppender SimpleLayout CRITICAL
    FileAppender XmlLayout
    INFO|3/26/2015 2:08:11 PM|Everything seems fine
    WARNING|3/26/2015 2:22:13 PM|Warning: ping is too high - disconnect imminent
    ERROR|3/26/2015 2:32:44 PM|Error parsing request
    CRITICAL|3/26/2015 2:38:01 PM|No connection string found in App.config
    FATAL|3/26/2015 2:39:19 PM|mscorlib.dll does not respond
    END

Output:
    3/26/2015 2:38:01 PM - CRITICAL - No connection string found in App.config
    3/26/2015 2:39:19 PM - FATAL - mscorlib.dll does not respond
    Logger info
    Appender type: ConsoleAppender, Layout type: SimpleLayout, Report level: CRITICAL, Messages appended: 2
    Appender type: FileAppender, Layout type: XmlLayout, Report level: INFO, Messages appended: 0, File size: 37526
*/
