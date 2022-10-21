package exercise.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        String pizzaName = tokens[1];
        int numberOfToppings = Integer.parseInt(tokens[2]);

        tokens = scanner.nextLine().split("\\s+");

        String flourType = tokens[1];
        String bakingTechnique = tokens[2];
        double doughWeight = Double.parseDouble(tokens[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);

            pizza.setDough(dough);

            String input = scanner.nextLine();

            while (!input.equals("END")) {
                tokens = input.split("\\s+");

                String toppingType = tokens[1];
                double toppingWeight = Double.parseDouble(tokens[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%n", pizzaName, pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
