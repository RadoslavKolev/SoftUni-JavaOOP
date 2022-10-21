package exercise.shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] peopleInput = scanner.nextLine().split(";");
        String[] productsInput = scanner.nextLine().split(";");

        for (String personStr : peopleInput) {
            String[] tokens = personStr.split("=");

            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            try {
                Person person = new Person(name, money);
                people.putIfAbsent(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (String productStr : productsInput) {
            String[] tokens = productStr.split("=");

            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            try {
                Product product = new Product(name, price);
                products.putIfAbsent(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            String productName = tokens[1];

            Person buyer = people.get(personName);
            Product product = products.get(productName);

            try {
                buyer.buyProduct(product);
                System.out.println(personName + " bought " + productName);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        people.values().forEach(System.out::println);
    }
}
