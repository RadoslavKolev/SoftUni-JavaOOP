package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static christmasRaces.common.ExceptionMessages.INVALID_NAME;
import static christmasRaces.common.ExceptionMessages.INVALID_NUMBER_OF_LAPS;
import static christmasRaces.common.ExceptionMessages.DRIVER_INVALID;
import static christmasRaces.common.ExceptionMessages.DRIVER_NOT_PARTICIPATE;
import static christmasRaces.common.ExceptionMessages.DRIVER_ALREADY_ADDED;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    private void setName(String name) {
        final int TARGET_LENGTH = 5;

        if (name == null || name.trim().length() < 5) {
            throw new IllegalArgumentException(
                String.format(INVALID_NAME, name, TARGET_LENGTH)
            );
        }

        this.name = name;
    }

    private void setLaps(int laps) {
        final int TARGET_LAPS = 1;

        if (laps < TARGET_LAPS) {
            throw new IllegalArgumentException(
                String.format(INVALID_NUMBER_OF_LAPS, TARGET_LAPS)
            );
        }

        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(this.drivers);
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        } else if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(
                String.format(DRIVER_NOT_PARTICIPATE, driver.getName())
            );
        } else if (this.drivers.contains(driver)) {
            throw new IllegalArgumentException(
                String.format(DRIVER_ALREADY_ADDED, driver.getName(), this.name)
            );
        }

        this.drivers.add(driver);
    }
}
