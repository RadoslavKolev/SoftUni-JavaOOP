package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        if (driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(
                String.format(DRIVER_EXISTS, driverName)
            );
        }

        Driver driver = new DriverImpl(driverName);
        this.driverRepository.add(driver);

        return String.format(DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(
                String.format(CAR_EXISTS, model)
            );
        }

        Car car = getCar(type, model, horsePower);
        this.carRepository.add(car);

        return String.format(CAR_CREATED, type + "Car", model);
    }

    @Override
    public String createRace(String raceName, int laps) {
        if (raceRepository.getByName(raceName) != null) {
            throw new IllegalArgumentException(
                String.format(RACE_EXISTS, raceName)
            );
        }

        Race race = new RaceImpl(raceName, laps);
        this.raceRepository.add(race);

        return String.format(RACE_CREATED, raceName);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        checkIfDriverExists(driverName, driver);

        Car car = carRepository.getByName(carModel);
        checkIfCarExists(driverName, car);

        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        checkIfRaceExists(raceName, race);

        Driver driver = driverRepository.getByName(driverName);
        checkIfDriverExists(driverName, driver);

        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        final int TARGET_DRIVERS = 3;

        Race race = raceRepository.getByName(raceName);
        checkIfRaceExists(raceName, race);

        if (race.getDrivers().size() < TARGET_DRIVERS) {
            throw new IllegalArgumentException(
                String.format(RACE_INVALID, raceName, TARGET_DRIVERS)
            );
        }

        Collection<Driver> drivers = race.getDrivers();
        int numberOfLaps = race.getLaps();

        List<Driver> winners = drivers.stream()
                .sorted((d1, d2) -> Double.compare(
                    d2.getCar().calculateRacePoints(numberOfLaps),
                    d1.getCar().calculateRacePoints(numberOfLaps)
                ))
                .limit(3)
                .collect(Collectors.toList()
        );

        winners.get(0).winRace();
        raceRepository.remove(race);

        String[] messages = {
            DRIVER_FIRST_POSITION,
            DRIVER_SECOND_POSITION,
            DRIVER_THIRD_POSITION
        };

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < TARGET_DRIVERS; i++) {
            builder.append(String.format(
                    messages[i], winners.get(i).getName(), race.getName())
            ).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

    private static Car getCar(String type, String model, int horsePower) {
        if (type.equals("Muscle")) {
            return new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            return new SportsCar(model, horsePower);
        }

        return null;
    }

    private static void checkIfDriverExists(String driverName, Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(
                String.format(DRIVER_NOT_FOUND, driverName)
            );
        }
    }

    private static void checkIfCarExists(String driverName, Car car) {
        if (car == null) {
            throw new IllegalArgumentException(
                String.format(CAR_NOT_FOUND, driverName)
            );
        }
    }

    private static void checkIfRaceExists(String raceName, Race race) {
        if (race == null) {
            throw new IllegalArgumentException(
                String.format(RACE_NOT_FOUND, raceName)
            );
        }
    }
}
