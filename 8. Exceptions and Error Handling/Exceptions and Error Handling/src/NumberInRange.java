import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = getRange(scanner);
        int min = range[0];
        int max = range[1];

        System.out.printf("Range: [%d...%d]%n", min, max);

        int validNum = readNumberInRange(scanner, min, max);
        System.out.printf("Valid number: %d%n", validNum);
    }

    private static int[] getRange(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int readNumberInRange(Scanner scanner, int min, int max) {
        while (true) {
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);

                if (number >= min && number <= max) return number;
            } catch (NumberFormatException ignored) {

            }

            System.out.println("Invalid number: " + input);
        }
    }
}
