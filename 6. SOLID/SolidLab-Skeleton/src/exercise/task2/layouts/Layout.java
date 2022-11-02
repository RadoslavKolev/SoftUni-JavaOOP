package exercise.task2.layouts;

import exercise.task2.enums.LogLevel;

public interface Layout {
    String format(String timeStamp, LogLevel level, String message);
}
