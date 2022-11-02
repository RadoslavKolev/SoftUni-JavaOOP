package exercise.task2.loggers;

import exercise.task2.appenders.Appender;
import exercise.task2.enums.LogLevel;

public class MessageLogger implements Logger {
    private final Appender appender;

    public MessageLogger(Appender appender) {
        this.appender = appender;
    }

    @Override
    public void logInfo(String timeStamp, String message) {
        appender.append(timeStamp, LogLevel.INFO, message);
    }

    @Override
    public void logWarning(String timeStamp, String message) {
        appender.append(timeStamp, LogLevel.WARNING, message);
    }

    @Override
    public void logError(String timeStamp, String message) {
        appender.append(timeStamp, LogLevel.ERROR, message);
    }

    @Override
    public void logCritical(String timeStamp, String message) {
        appender.append(timeStamp, LogLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String timeStamp, String message) {
        appender.append(timeStamp, LogLevel.FATAL, message);
    }
}
