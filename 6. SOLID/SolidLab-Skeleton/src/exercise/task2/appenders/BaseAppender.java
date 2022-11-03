package exercise.task2.appenders;

import exercise.task2.layouts.Layout;

public abstract class BaseAppender implements Appender {
    private final Layout layout;
    protected int messages;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return this.layout;
    }

    @Override
    public int getMessages() {
        return this.messages;
    }
}
