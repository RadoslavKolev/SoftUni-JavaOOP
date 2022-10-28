package exercise.vehicles;

public class Truck extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.6;
    private final static double TINY_HOLE_TANK_CONSUMPTION = 0.95;

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        double litersFilled = liters * TINY_HOLE_TANK_CONSUMPTION;
        super.refuel(super.getFuelQuantity() + litersFilled);
    }
}
