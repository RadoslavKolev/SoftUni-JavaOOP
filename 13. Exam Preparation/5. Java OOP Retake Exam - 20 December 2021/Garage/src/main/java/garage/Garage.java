package garage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private final List<Car> cars;

    public Garage() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public int getCount() {
        return this.cars.size();
    }

    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car can't be null");
        }

        this.cars.add(car);
    }

    public List<Car> findAllCarsWithMaxSpeedAbove(int speed) {
        return this.cars.stream()
                .filter(c -> c.getMaxSpeed() > speed)
                .collect(Collectors.toList());
    }

    public List<Car> findAllCarsByBrand(String brand) {
        return this.cars.stream()
                .filter(c -> c.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    public Car getTheMostExpensiveCar() {
        return this.cars.stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(1)
                .findFirst()
                .orElse(null);
    }
}