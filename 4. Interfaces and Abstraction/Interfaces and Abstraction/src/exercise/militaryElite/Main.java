package exercise.militaryElite;

import exercise.militaryElite.military.*;
import exercise.militaryElite.military.enums.Corps;
import exercise.militaryElite.military.enums.State;
import exercise.militaryElite.military.missions.MissionImpl;
import exercise.militaryElite.military.repairs.Repair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        executeCommands(scanner);
    }

    private static void executeCommands(Scanner scanner) {
        Map<Integer, PrivateImpl> soldiersMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary = 0.0;

            if (!soldierType.equals("Spy")) {
                salary = Double.parseDouble(tokens[4]);
            }

            switch (soldierType) {
                case "Private" -> {
                    PrivateImpl privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiersMap.putIfAbsent(id, privateSoldier);
                    System.out.println(privateSoldier);
                }
                case "LieutenantGeneral" -> {
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    addPrivatesById(soldiersMap, tokens, lieutenantGeneral);
                    System.out.println(lieutenantGeneral);
                }
                case "Engineer" -> {
                    Corps engineerCorps = getCorps(tokens[5]);

                    if (engineerCorps == null) {
                        input = scanner.nextLine();
                        continue;
                    }

                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, engineerCorps);
                    addRepairs(tokens, engineer);
                    System.out.println(engineer);
                }
                case "Commando" -> {
                    Corps commandoCorps = getCorps(tokens[5]);

                    if (commandoCorps == null) {
                        input = scanner.nextLine();
                        continue;
                    }

                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, commandoCorps);
                    addMissions(tokens, commando);
                    System.out.println(commando);
                }
                case "Spy" -> {
                    String codeNumber = tokens[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    System.out.println(spy);
                }
                default -> System.out.println("No such soldier type!");
            }

            input = scanner.nextLine();
        }
    }

    private static void addPrivatesById(Map<Integer, PrivateImpl> soldiersMap, String[] tokens, LieutenantGeneralImpl lieutenantGeneral) {
        for (int i = 5; i < tokens.length; i++) {
            int currentId = Integer.parseInt(tokens[i]);
            PrivateImpl currentPrivate = soldiersMap.get(currentId);
            lieutenantGeneral.addPrivate(currentPrivate);
        }
    }

    private static Corps getCorps(String corpsStr) {
        if (!validateCorps(corpsStr)) return null;

        return (corpsStr.equals(Corps.AIRFORCE.getName())
                ? Corps.AIRFORCE : Corps.MARINE);
    }

    private static boolean validateCorps(String corps) {
        return corps.equals(Corps.AIRFORCE.getName()) ||
                corps.equals(Corps.MARINE.getName());
    }

    private static void addRepairs(String[] tokens, EngineerImpl engineer) {
        for (int i = 6; i < tokens.length; i += 2) {
            String partName = tokens[i];
            int hoursWorked = Integer.parseInt(tokens[i + 1]);

            Repair repair = new Repair(partName, hoursWorked);

            engineer.addRepair(repair);
        }
    }

    private static void addMissions(String[] tokens, CommandoImpl commando) {
        for (int i = 6; i < tokens.length; i += 2) {
            String codeName = tokens[i];
            State missionState = getState(tokens[i + 1]);

            if (missionState == null) continue;

            MissionImpl mission = new MissionImpl(codeName, missionState);

            commando.addMission(mission);
        }
    }

    private static State getState(String stateStr) {
        if (!validateState(stateStr)) return null;

        return (stateStr.equals(State.IN_PROGRESS.getName())
                ? State.IN_PROGRESS : State.FINISHED);
    }

    private static boolean validateState(String state) {
        return state.equals(State.IN_PROGRESS.getName()) ||
                state.equals(State.FINISHED.getName());
    }
}
