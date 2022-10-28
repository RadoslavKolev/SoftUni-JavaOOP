package exercise.vehicles;

public class Car extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER_CONSUMPTION);
    }
}
