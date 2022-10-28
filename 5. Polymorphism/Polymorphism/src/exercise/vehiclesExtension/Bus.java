package exercise.vehiclesExtension;

public class Bus extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.4;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double litersPerKm, int tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
        this.isEmpty = true;
    }

    // Function overloading - added another boolean parameter
    public String drive(double distance, boolean empty) {
        if (!isEmpty && empty) {
            super.setFuelConsumption(super.getFuelConsumption() - AIR_CONDITIONER_CONSUMPTION);
            this.isEmpty = true;
        } else if (isEmpty && !empty) {
            this.isEmpty = false;
            super.setFuelConsumption(super.getFuelConsumption() + AIR_CONDITIONER_CONSUMPTION);
        }

        return super.drive(distance);
    }
}
