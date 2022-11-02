package exercise.task1.products.drinks;

import exercise.task1.products.Product;

public class Coke implements Product, Drink {
    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;
    private final double milliliters;
    private final double weight;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
        this.weight = milliliters * DENSITY;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * this.weight;
    }

    @Override
    public double getDrinkInLiters() {
        return this.weight / GRAMS_PER_1_KILOGRAM;
    }
}
