package lection.product;

public class CarBuilderFacade {
    protected Car car;

    public CarBuilderFacade() {
        this.car = new Car();
    }

    public Car build() {
        return this.car;
    }

    public CarInfoBuilder carInfo() {
        return new CarInfoBuilder(this.car);
    }

    public CarAddressBuilder placeBuilt() {
        return new CarAddressBuilder(this.car);
    }
}
