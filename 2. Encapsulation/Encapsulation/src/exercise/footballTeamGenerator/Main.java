package exercise.footballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        executeCommands(scanner, teams);
    }

    private static void executeCommands(Scanner scanner, Map<String, Team> teams) {
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");

            String command = tokens[0];
            String teamName = tokens[1];

            try {
                switch (command) {
                    case "Team" -> createTeam(teams, teamName);
                    case "Add" -> addPlayer(teams, tokens, teamName);
                    case "Remove" -> removePlayer(teams, tokens, teamName);
                    case "Rating" -> printTeamRating(teams, teamName);
                    default -> throw new IllegalArgumentException("No such command!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }

    private static void createTeam(Map<String, Team> teams, String teamName) {
        Team team = new Team(teamName);
        teams.putIfAbsent(teamName, team);
    }

    private static void addPlayer(Map<String, Team> teams, String[] tokens, String teamName) {
        checkIfTeamExists(teams, teamName);

        String playerName = tokens[2];
        int endurance = Integer.parseInt(tokens[3]);
        int sprint = Integer.parseInt(tokens[4]);
        int dribble = Integer.parseInt(tokens[5]);
        int passing = Integer.parseInt(tokens[6]);
        int shooting = Integer.parseInt(tokens[7]);

        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

        teams.get(teamName).addPlayer(player);
    }

    private static void removePlayer(Map<String, Team> teams, String[] tokens, String teamName) {
        checkIfTeamExists(teams, teamName);

        String playerName = tokens[2];
        teams.get(teamName).removePlayer(playerName);
    }

    private static void printTeamRating(Map<String, Team> teams, String teamName) {
        checkIfTeamExists(teams, teamName);

        System.out.printf(
                "%s - %d%n", teamName,
                Math.round(teams.get(teamName).getRating())
        );
    }

    private static void checkIfTeamExists(Map<String, Team> teams, String team) {
        if (!teams.containsKey(team)) {
            String exceptionMessage = String.format(
                    "Team %s does not exist.",
                    team
            );

            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
