package lection.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> society = new ArrayList<>();

        fillList(scanner, society);

        String fakeIdLastDigits = scanner.nextLine();

        printDetainedIDs(society, fakeIdLastDigits);
    }

    private static void fillList(Scanner scanner, List<Identifiable> society) {
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            Identifiable member = checkIfRobotOrCitizen(tokens);
            society.add(member);

            input = scanner.nextLine();
        }
    }

    private static Identifiable checkIfRobotOrCitizen(String[] tokens) {
        Identifiable member = null;

        if (tokens.length == 2) {
            // Robot case
            String model = tokens[0];
            String id = tokens[1];

            member = new Robot(model, id);
        } else if (tokens.length == 3) {
            // Citizen case
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String id = tokens[2];

            member = new Citizen(name, age, id);
        }

        return member;
    }

    private static void printDetainedIDs(List<Identifiable> society, String fakeIdLastDigits) {
        for (Identifiable member : society) {
            if (member.getId().endsWith(fakeIdLastDigits)) {
                System.out.println(member.getId());
            }
        }
    }
}
