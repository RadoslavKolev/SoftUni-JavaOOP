package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {
    private final Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public void add(Car model) {
        this.cars.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return this.cars.remove(model);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.cars);
    }

    @Override
    public Car getByName(String name) {
        return this.cars.stream()
                .filter(car -> car.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }
}
