package exercise.task2.appenders;

public interface Appender {
    void append(String timeStamp, String level, String message);
}
