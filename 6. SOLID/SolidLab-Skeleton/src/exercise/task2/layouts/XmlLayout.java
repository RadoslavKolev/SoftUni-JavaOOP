package exercise.task2.layouts;

import exercise.task2.enums.LogLevel;

public class XmlLayout implements Layout{
    @Override
    public String format(String timeStamp, LogLevel level, String message) {
        return String.format(
                "<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>",
                timeStamp, level, message
        );
    }
}
