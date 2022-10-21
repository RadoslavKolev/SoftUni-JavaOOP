package exercise.pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name.length() < 1 || name.length() > 15) {
            String exceptionMessage = "Pizza name should be between 1 and 15 symbols.";
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            String exceptionMessage = "Number of toppings should be in range [0..10].";
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double doughCalories = dough.calculateCalories();
        double toppingsCalories = 0.0;

        for (Topping topping : toppings) {
            toppingsCalories += topping.calculateCalories();
        }

        return doughCalories + toppingsCalories;
    }
}
