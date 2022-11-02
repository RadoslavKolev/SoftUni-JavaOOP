package exercise.task2.appenders;

import exercise.task2.layouts.Layout;

public class ConsoleAppender implements Appender {
    private final Layout layout;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void append(String timeStamp, String level, String message) {
        System.out.println(layout.format(timeStamp, level, message));
    }
}
