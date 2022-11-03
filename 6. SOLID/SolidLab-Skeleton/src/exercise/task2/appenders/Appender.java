package exercise.task2.appenders;

import exercise.task2.enums.LogLevel;
import exercise.task2.layouts.Layout;

public interface Appender {
    void append(String timeStamp, LogLevel level, String message);
    Layout getLayout();
    int getMessages();
}
