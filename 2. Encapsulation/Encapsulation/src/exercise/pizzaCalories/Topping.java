package exercise.pizzaCalories;

import java.util.Arrays;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        boolean isValid = Arrays
                .stream(Toppings.values())
                .anyMatch(topping -> topping.name().equals(toppingType));

        if (!isValid) {
            String exceptionMessage = String.format(
                "Cannot place %s on top of your pizza.",
                toppingType
            );

            throw new IllegalArgumentException(exceptionMessage);
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1.0 || weight > 50.0) {
            String exceptionMessage = String.format(
                "%s weight should be in the range [1..50].",
                this.toppingType
            );
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        Toppings toppingEnum = Toppings.valueOf(this.toppingType);
        double toppingModifier = toppingEnum.getModifier();
        return (2 * this.weight) * toppingModifier;
    }
}
