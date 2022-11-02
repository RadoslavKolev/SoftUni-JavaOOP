package exercise.task2.appenders;

import exercise.task2.enums.LogLevel;

public interface Appender {
    void append(String timeStamp, LogLevel level, String message);
}
