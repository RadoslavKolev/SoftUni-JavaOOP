package lection.carShopExtended.cars;

import lection.carShopExtended.interfaces.Sellable;

public class Seat extends BaseCar implements Sellable {
    private final Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%n%s sells for %f",
                super.toString(), this.getModel(), this.price
        );
    }
}
