package exercise.vehiclesExtension;

public class Truck extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.6;
    private final static double TINY_HOLE_TANK_CONSUMPTION = 0.95;

    public Truck(double fuelQuantity, double litersPerKm, int tankCapacity) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * TINY_HOLE_TANK_CONSUMPTION);
    }
}
