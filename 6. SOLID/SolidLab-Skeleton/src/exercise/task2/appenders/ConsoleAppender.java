package exercise.task2.appenders;

import exercise.task2.enums.LogLevel;
import exercise.task2.layouts.Layout;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timeStamp, LogLevel level, String message) {
        super.messages++;
        System.out.println(getLayout().format(timeStamp, level, message));
    }
}
