package exercise.vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] carInfo = readInfo(scanner);
        String[] truckInfo = readInfo(scanner);

        Vehicle car = createVehicle(carInfo);
        Vehicle truck = createVehicle(truckInfo);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        executeCommands(scanner, vehicles, n);

        vehicles.values().forEach(System.out::println);
    }

    private static String[] readInfo(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static Vehicle createVehicle(String[] vehicleInfo) {
        String vehicleType = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double litersPerKm = Double.parseDouble(vehicleInfo[2]);

        return switch (vehicleType) {
            case "Car" -> new Car(fuelQuantity, litersPerKm);
            case "Truck" -> new Truck(fuelQuantity, litersPerKm);
            default -> null;
        };
    }

    private static void executeCommands(Scanner scanner, Map<String, Vehicle> vehicles, int n) {
        for (int i = 0; i < n; i++) {
            String[] tokens = readInfo(scanner);
            String command = tokens[0];
            String vehicleType = tokens[1];

            switch (command) {
                case "Drive" -> driveVehicle(vehicles, tokens, vehicleType);
                case "Refuel" -> refuelVehicle(vehicles, tokens, vehicleType);
            }
        }
    }

    private static void driveVehicle(Map<String, Vehicle> vehicles, String[] tokens, String vehicleType) {
        double distance = Double.parseDouble(tokens[2]);
        String message = vehicles.get(vehicleType).drive(distance);
        System.out.println(message);
    }

    private static void refuelVehicle(Map<String, Vehicle> vehicles, String[] tokens, String vehicleType) {
        double liters = Double.parseDouble(tokens[2]);
        vehicles.get(vehicleType).refuel(liters);
    }
}
