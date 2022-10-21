package exercise.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().replace("Pizza ", "").split("\\s+");

        String pizzaName = tokens[0];
        int numberOfToppings = Integer.parseInt(tokens[1]);

        Pizza pizza;

        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        tokens = scanner.nextLine().replace("Dough ", "").split("\\s+");

        String flourType = tokens[0];
        String bakingTechnique = tokens[1];
        double doughWeight = Double.parseDouble(tokens[2]);

        Dough dough;

        try {
            dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] elements = input.replace("Topping ", "").split("\\s+");

            String toppingType = elements[0];
            double toppingWeight = Double.parseDouble(elements[1]);

            try {
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            input = scanner.nextLine();
        }

        System.out.printf("%s - %.2f%n", pizzaName, pizza.getOverallCalories());
    }
}
