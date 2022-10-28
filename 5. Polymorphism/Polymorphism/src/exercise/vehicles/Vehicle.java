package exercise.vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        String vehicleType = this.getClass().getSimpleName();

        if (this.fuelQuantity < fuelNeeded) {
            return String.format("%s needs refueling", vehicleType);
        }

        this.fuelQuantity -= fuelNeeded;
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s travelled %s km", vehicleType, df.format(distance));
    }

    @Override
    public String toString() {
        String vehicleType = this.getClass().getSimpleName();
        return String.format("%s: %.2f", vehicleType, this.fuelQuantity);
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }
}
