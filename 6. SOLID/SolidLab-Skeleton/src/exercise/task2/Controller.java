package exercise.task2;

import exercise.task2.appenders.Appender;
import exercise.task2.appenders.ConsoleAppender;
import exercise.task2.layouts.Layout;
import exercise.task2.layouts.SimpleLayout;

public class Controller {
    public static void main(String[] args) {
        Layout layout = new SimpleLayout();
        Appender appender = new ConsoleAppender(layout);

        appender.append("3/26/2015 2:08:11 PM", "ERROR", "Error parsing JSON.");
    }
}
