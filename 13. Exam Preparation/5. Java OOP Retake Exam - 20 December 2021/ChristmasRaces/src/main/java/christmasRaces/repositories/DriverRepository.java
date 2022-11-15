package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {
    private final Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public void add(Driver model) {
        this.drivers.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return this.drivers.remove(model);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.drivers);
    }

    @Override
    public Driver getByName(String name) {
        return this.drivers.stream()
                .filter(driver -> driver.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
