package exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getDimensions(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        fillGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
        long starsCollected = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = getDimensions(command);
            int[] evilCoordinates = getDimensions(scanner.nextLine());

            int currentEvilRow = evilCoordinates[0];
            int currentEvilCol = evilCoordinates[1];

            moveEvil(galaxy, currentEvilRow, currentEvilCol);

            int currentJediRow = jediCoordinates[0];
            int currentJediCol = jediCoordinates[1];

            starsCollected = moveJedi(galaxy, currentJediRow, currentJediCol);

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);
    }

    private static int[] getDimensions(String input) {
        return Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void fillGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }

    private static void moveEvil(int[][] galaxy, int currentEvilRow, int currentEvilCol) {
        while (currentEvilRow >= 0 && currentEvilCol >= 0) {
            if (isInBounds(galaxy, currentEvilRow, currentEvilCol)) {
                galaxy[currentEvilRow][currentEvilCol] = 0;
            }

            currentEvilRow--;
            currentEvilCol--;
        }
    }

    private static long moveJedi(int[][] galaxy, int currentJediRow, int currentJediCol) {
        long starsCollected = 0;

        while (currentJediRow >= 0 && currentJediCol < galaxy[1].length) {
            if (isInBounds(galaxy, currentJediRow, currentJediCol)) {
                starsCollected += galaxy[currentJediRow][currentJediCol];
            }

            currentJediCol++;
            currentJediRow--;
        }

        return starsCollected;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }
}
