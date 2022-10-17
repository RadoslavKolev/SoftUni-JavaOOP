package lection.pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading and setting the coordinates
        int[] coordinates = readArray(scanner);

        Point A = new Point(coordinates[0], coordinates[1]);
        Point B = new Point(coordinates[2], coordinates[3]);

        // Creating the rectangle
        Rectangle rectangle = new Rectangle(A, B);

        int n = Integer.parseInt(scanner.nextLine());

        // Reading several points and checking if they're in/out of the rectangle
        for (int i = 0; i < n; i++) {
            int[] currentCoordinates = readArray(scanner);
            Point currentPoint = new Point(currentCoordinates[0], currentCoordinates[1]);
            System.out.println(rectangle.contains(currentPoint));
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
