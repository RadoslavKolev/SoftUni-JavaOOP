package exercise.birthdayCelebrations;

import exercise.birthdayCelebrations.creatures.Citizen;
import exercise.birthdayCelebrations.creatures.Pet;
import exercise.birthdayCelebrations.interfaces.Birthable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> creatures = new ArrayList<>();

        fillList(scanner, creatures);

        String yearToSearch = scanner.nextLine();

        printBirthDates(creatures, yearToSearch);
    }

    private static void fillList(Scanner scanner, List<Birthable> creatures) {
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String creatureType = tokens[0];

            Birthable creature = checkCreatureType(creatureType, tokens);

            // If create is not Robot (Robot doesn't implement Birthable)
            if (creature != null) {
                creatures.add(creature);
            }

            input = scanner.nextLine();
        }
    }

    private static Birthable checkCreatureType(String creatureType, String[] tokens) {
        Birthable creature = null;

        switch (creatureType) {
            case "Citizen":
                String citizenName = tokens[1];
                int citizenAge = Integer.parseInt(tokens[2]);
                String citizenId = tokens[3];
                String citizenBirthDate = tokens[4];

                creature = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                break;
            case "Pet":
                String petName = tokens[1];
                String petBirthDate = tokens[2];

                creature = new Pet(petName, petBirthDate);
                break;
            case "Robot":
                // TODO: Implement Robot logic
                break;
            default:
                System.out.println("No such creature");
        }

        return creature;
    }

    private static void printBirthDates(List<Birthable> creatures, String yearToSearch) {
        for (Birthable creature : creatures) {
            if (creature.getBirthDate().endsWith(yearToSearch)) {
                System.out.println(creature.getBirthDate());
            }
        }
    }
}
