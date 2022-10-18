package exercise.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TrafficLights> trafficLights = new ArrayList<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            trafficLights.add(TrafficLights.valueOf(token));
        }

        int n = Integer.parseInt(scanner.nextLine());
        int size = trafficLights.size();

        for (int i = 0; i < n; i++) {
            StringBuilder output = new StringBuilder();

            for (int j = 0; j < size; j++) {
                TrafficLights currentSignal = trafficLights.get(j);
                TrafficLights nextSignal = TrafficLights.valueOf(currentSignal.getNextSignal());
                trafficLights.set(j, nextSignal);
                output.append(currentSignal.getNextSignal()).append(" ");
            }

            System.out.println(output.toString().trim());
        }
    }
}
