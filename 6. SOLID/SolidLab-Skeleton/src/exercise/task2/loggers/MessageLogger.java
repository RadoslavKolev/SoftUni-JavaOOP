package exercise.task2.loggers;

import exercise.task2.appenders.Appender;

public class MessageLogger implements Logger {
    private final Appender appender;

    public MessageLogger(Appender appender) {
        this.appender = appender;
    }

    @Override
    public void logInfo(String timeStamp, String message) {
        appender.append(timeStamp, "INFO", message);
    }

    @Override
    public void logWarning(String timeStamp, String message) {
        appender.append(timeStamp, "WARNING", message);
    }

    @Override
    public void logError(String timeStamp, String message) {
        appender.append(timeStamp, "ERROR", message);
    }

    @Override
    public void logCritical(String timeStamp, String message) {
        appender.append(timeStamp, "CRITICAL", message);
    }

    @Override
    public void logFatal(String timeStamp, String message) {
        appender.append(timeStamp, "FATAL", message);
    }
}
