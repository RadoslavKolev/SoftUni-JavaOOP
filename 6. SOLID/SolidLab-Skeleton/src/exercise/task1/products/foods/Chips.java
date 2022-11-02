package exercise.task1.products.foods;

import exercise.task1.products.Product;

public class Chips implements Product, Food {
    private static final double CALORIES_PER_100_GRAMS = 529.0;
    private final double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return this.grams;
    }

    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * this.grams;
    }

    @Override
    public double getFoodInKilograms() {
        return this.grams / GRAMS_PER_1_KILOGRAM;
    }
}
