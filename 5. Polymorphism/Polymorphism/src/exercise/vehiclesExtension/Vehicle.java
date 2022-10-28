package exercise.vehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
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

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
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

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (liters + this.fuelQuantity > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }

    @Override
    public String toString() {
        String vehicleType = this.getClass().getSimpleName();
        return String.format("%s: %.2f", vehicleType, this.fuelQuantity);
    }
}
