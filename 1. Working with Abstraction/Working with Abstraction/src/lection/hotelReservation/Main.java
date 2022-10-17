package lection.hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2]);
        Discount discount = Discount.valueOf(tokens[3]);

        System.out.printf(
            "%.2f%n",
            PriceCalculator.calculateTotalPrice(
                pricePerDay,
                numberOfDays,
                season,
                discount
            )
        );
    }
}
