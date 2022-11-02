package exercise.task2.layouts;

public class SimpleLayout implements Layout {
    @Override
    public String format(String timeStamp, String level, String message) {
        return String.format(
            "%s - %s - %s",
            timeStamp, level, message
        );
    }
}
