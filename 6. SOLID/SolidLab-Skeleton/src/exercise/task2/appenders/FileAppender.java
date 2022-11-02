package exercise.task2.appenders;

import exercise.task2.enums.LogLevel;
import exercise.task2.layouts.Layout;
import exercise.task2.utilities.File;

public class FileAppender implements Appender{
    private final Layout layout;
    private final File file;

    public FileAppender(Layout layout, File file) {
        this.layout = layout;
        this.file = file;
    }

    @Override
    public void append(String timeStamp, LogLevel level, String message) {
        file.write(layout.format(timeStamp, level, message));
    }
}
