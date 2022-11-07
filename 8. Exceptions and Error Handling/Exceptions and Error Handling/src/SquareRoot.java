import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int num = Integer.parseInt(scanner.nextLine());
            double sqrt = calcSqrt(num);
            System.out.printf("%.2f%n", sqrt);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid");
        }

        // Could be done with finally {}, but this is better
        System.out.println("Goodbye");
    }

    private static double calcSqrt(int num) throws IllegalArgumentException {
        if (num < 0) throw new IllegalArgumentException();

        return Math.sqrt(num);
    }
}
