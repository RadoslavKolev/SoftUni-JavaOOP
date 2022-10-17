package lection.hotelReservation;

public class PriceCalculator {
    public static double calculateTotalPrice(double pricePerDay, int days, Season season, Discount discount) {
        int multiplier = season.getValue();

        double discountMultiplier = discount.getValue() / 100.00;
        double priceBeforeDiscount = pricePerDay * days * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;

        return priceBeforeDiscount - discountedAmount;
    }
}
