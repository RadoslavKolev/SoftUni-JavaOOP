package exercise.telephony;

import exercise.telephony.interfaces.Browsable;
import exercise.telephony.interfaces.Callable;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();

        for (String phoneNumber : numbers) {
            if (!hasOnlyNumbers(phoneNumber)) {
                builder.append("Invalid number!")
                        .append(System.lineSeparator());
            } else {
                builder.append(String.format("Calling... %s", phoneNumber))
                        .append(System.lineSeparator());
            }
        }

        return builder.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();

        for (String url : urls) {
            if (hasNumber(url)) {
                builder.append("Invalid URL!")
                        .append(System.lineSeparator());
            } else {
                builder.append(String.format("Browsing: %s!", url))
                        .append(System.lineSeparator());
            }
        }

        return builder.toString().trim();
    }

    private static boolean hasNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
