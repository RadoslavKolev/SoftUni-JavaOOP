import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {
    public static void main(String[] args) {
        final int TARGET_VALUE_OF_NUMBERS = 10;
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        int min = 1;    // Initial Min value
        int counter = 0;

        while (counter != TARGET_VALUE_OF_NUMBERS) {
            int number;

            try {
                number = readNumber(scanner, min);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                continue;
            }

            numbers.add(number);
            min = number;
            counter++;
        }

        System.out.println(numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "))
        );
    }

    private static int readNumber(Scanner scanner, int min) {
        final int MAX = 100;
        String input = scanner.nextLine();
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid Number!");
        }

        if (number <= min || number >= MAX) {
            String exceptionMessage = String.format(
                "Your number is not in range %d - %d!",
                min, MAX
            );

            throw new IllegalStateException(exceptionMessage);
        }

        return number;
    }
}
