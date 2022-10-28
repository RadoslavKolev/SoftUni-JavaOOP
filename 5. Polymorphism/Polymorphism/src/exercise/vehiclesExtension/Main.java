package exercise.vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] carInfo = readVehicleInfo(scanner);
        String[] truckInfo = readVehicleInfo(scanner);
        String[] busInfo = readVehicleInfo(scanner);

        Vehicle car = createVehicle(carInfo);
        Vehicle truck = createVehicle(truckInfo);
        Vehicle bus = createVehicle(busInfo);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        executeCommands(scanner, vehicles, n);

        vehicles.values().forEach(System.out::println);
    }

    private static String[] readVehicleInfo(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static Vehicle createVehicle(String[] vehicleInfo) {
        String vehicleType = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double litersPerKm = Double.parseDouble(vehicleInfo[2]);
        int tankCapacity = Integer.parseInt(vehicleInfo[3]);

        return switch (vehicleType) {
            case "Car" -> new Car(fuelQuantity, litersPerKm, tankCapacity);
            case "Truck" -> new Truck(fuelQuantity, litersPerKm, tankCapacity);
            case "Bus" -> new Bus(fuelQuantity, litersPerKm, tankCapacity);
            default -> null;
        };
    }

    private static void executeCommands(Scanner scanner, Map<String, Vehicle> vehicles, int n) {
        for (int i = 0; i < n; i++) {
            String[] tokens = readVehicleInfo(scanner);
            String command = tokens[0];
            String vehicleType = tokens[1];

            switch (command) {
                case "Drive" -> driveVehicle(vehicles, tokens, vehicleType);
                case "DriveEmpty" -> driveEmptyBus(vehicles, tokens, vehicleType);
                case "Refuel" -> refuelVehicle(vehicles, tokens, vehicleType);
            }
        }
    }

    private static void driveVehicle(Map<String, Vehicle> vehicles, String[] tokens, String vehicleType) {
        double distance = Double.parseDouble(tokens[2]);
        Vehicle vehicle = vehicles.get(vehicleType);

        String message = checkVehicle(vehicles, vehicleType, distance, vehicle);
        System.out.println(message);
    }

    private static String checkVehicle(Map<String, Vehicle> vehicles, String vehicleType, double distance, Vehicle vehicle) {
        if (vehicle instanceof Bus) {
            return ((Bus) vehicle).drive(distance, false);
        } else {
            return vehicles.get(vehicleType).drive(distance);
        }
    }

    private static void driveEmptyBus(Map<String, Vehicle> vehicles, String[] tokens, String vehicleType) {
        double distance = Double.parseDouble(tokens[2]);
        Bus bus = (Bus) vehicles.get(vehicleType);

        String message = bus.drive(distance, true);
        System.out.println(message);
    }

    private static void refuelVehicle(Map<String, Vehicle> vehicles, String[] tokens, String vehicleType) {
        double liters = Double.parseDouble(tokens[2]);
        vehicles.get(vehicleType).refuel(liters);
    }
}
