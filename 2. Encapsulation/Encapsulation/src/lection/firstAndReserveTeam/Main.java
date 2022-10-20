package lection.firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> players = new ArrayList<>(n);

        fillPlayers(reader, n, players);

        Team team = new Team("Black Eagles");

        // Returns unmodifiable list
        // So we cannot make changes to it
//        for (Person player : players) {
//            if (player.getAge() < 40) {
//                team.getFirstTeam().add(player);
//            } else {
//                team.getReverseTeam().add(player);
//            }
//        }

        for (Person player : players) {
            team.addPlayer(player);
        }

        int firstSize = team.getSize(team.getFirstTeam());
        int reserveSize = team.getSize(team.getReserveTeam());

        print("First", firstSize);
        print("Second", reserveSize);
    }

    private static void fillPlayers(BufferedReader reader, int n, List<Person> players) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            validate(players, firstName, lastName, age, salary);
        }
    }

    private static void validate(List<Person> players, String firstName, String lastName, int age, double salary) {
        try {
            players.add(new Person(firstName, lastName, age, salary));
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }
    }

    private static void print(String message, int size) {
        System.out.printf(
            "%s team have %d players%n",
            message, size
        );
    }
}
