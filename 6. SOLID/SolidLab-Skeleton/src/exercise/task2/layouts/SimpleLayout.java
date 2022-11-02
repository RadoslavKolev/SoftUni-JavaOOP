package exercise.task2.layouts;

import exercise.task2.enums.LogLevel;

public class SimpleLayout implements Layout {
    @Override
    public String format(String timeStamp, LogLevel level, String message) {
        return String.format(
            "%s - %s - %s",
            timeStamp, level, message
        );
    }
}
