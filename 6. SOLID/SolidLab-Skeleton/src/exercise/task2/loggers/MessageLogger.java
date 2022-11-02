package exercise.task2.loggers;

import exercise.task2.appenders.Appender;
import exercise.task2.enums.LogLevel;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.setAppenders(appenders);
    }

    public void setAppenders(Appender[] appenders) {
        if (appenders == null || appenders.length == 0) {
            String exceptionMessage = "Message logger should have at least one parameter";
            throw new IllegalArgumentException(exceptionMessage);
        }

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
        for (Appender appender : appenders) {
            appender.append(timeStamp, level, message);
        }
    }
}
