package exercise.task2.loggers;

import exercise.task2.appenders.Appender;
import exercise.task2.appenders.FileAppender;
import exercise.task2.enums.LogLevel;

import java.util.Map;

public class MessageLogger implements Logger {
    private Map<Appender, LogLevel> appenders;

    public MessageLogger(Map<Appender, LogLevel> appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.INFO, message);
    }

    @Override
    public void logWarning(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.WARNING, message);
    }

    @Override
    public void logError(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.ERROR, message);
    }

    @Override
    public void logCritical(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.FATAL, message);
    }

    private void logToAll(String timeStamp, LogLevel level, String message) {
        for (var entry : appenders.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel appenderLevel = entry.getValue();

            if (appenderLevel.ordinal() <= level.ordinal()) {
                appender.append(timeStamp, level, message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Logger info").append(System.lineSeparator());

        for (var entry : appenders.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel level = entry.getValue();

            builder.append(String.format(
                    "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                    appender.getClass().getSimpleName(),
                    appender.getLayout().getClass().getSimpleName(),
                    level.toString(),
                    appender.getMessages()
            ));

            if (appender instanceof FileAppender) {
                builder.append(String.format(
                        ", File size: %d",
                        ((FileAppender) appender).getFile().size()
                ));
            }

            builder.append(System.lineSeparator());
        }


        return builder.toString().trim();
    }
}
