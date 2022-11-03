package exercise.task2.appenders;

import exercise.task2.enums.LogLevel;
import exercise.task2.layouts.Layout;
import exercise.task2.utilities.File;

public class FileAppender extends BaseAppender {
    private final File file;

    public FileAppender(Layout layout, File file) {
        super(layout);
        this.file = file;
    }

    @Override
    public void append(String timeStamp, LogLevel level, String message) {
        file.write(getLayout().format(timeStamp, level, message));
    }

    public File getFile() {
        return this.file;
    }
}
