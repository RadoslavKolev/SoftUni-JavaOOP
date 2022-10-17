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

/*
    Input:
    0 0 3 3
    5
    0 0
    0 1
    4 4
    5 3
    1 2

    Output:
    true
    true
    false
    false
    true
--------------------------------
    Input:
    2 -3 12 3
    4
    8 -1
    11 3
    1 1
    2 4

    Output:
    true
    true
    false
    false
--------------------------------
    Input:
    5 8 12 15
    6
    0 0
    5 8
    12 15
    8 15
    7 15
    8 12

    Output:
    false
    true
    true
    true
    true
    true
 */
