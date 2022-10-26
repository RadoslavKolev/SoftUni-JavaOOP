package exercise.foodShortage;

import exercise.foodShortage.buyers.Citizen;
import exercise.foodShortage.buyers.Rebel;
import exercise.foodShortage.interfaces.Buyer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyers = new HashMap<>();
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        fillMap(scanner, buyers, numberOfPeople);

        buyFoodMain(scanner, buyers);
        System.out.println(calcTotalFood(buyers));
    }

    private static void fillMap(Scanner scanner, Map<String, Buyer> buyers, int numberOfPeople) {
        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];

            Buyer buyer = checkIfRebelOrCitizen(tokens, name);

            buyers.putIfAbsent(name, buyer);
        }
    }

    private static Buyer checkIfRebelOrCitizen(String[] tokens, String name) {
        Buyer buyer = null;

        int age = Integer.parseInt(tokens[1]);

        if (tokens.length == 3) {
            // Rebels case
            String group = tokens[2];

            buyer = new Rebel(name, age, group);
        } else if (tokens.length == 4) {
            // Citizens case
            String id = tokens[2];
            String birthDate = tokens[3];

            buyer = new Citizen(name, age, id, birthDate);
        }

        return buyer;
    }

    private static void buyFoodMain(Scanner scanner, Map<String, Buyer> buyers) {
        String nameToCheck = scanner.nextLine();

        while (!nameToCheck.equals("End")) {
            if (buyers.containsKey(nameToCheck)) {
                buyers.get(nameToCheck).buyFood();
            }

            nameToCheck = scanner.nextLine();
        }
    }

    private static int calcTotalFood(Map<String, Buyer> buyers) {
        return buyers.values().stream()
                .mapToInt(Buyer::getFood)
                .sum();
    }
}
