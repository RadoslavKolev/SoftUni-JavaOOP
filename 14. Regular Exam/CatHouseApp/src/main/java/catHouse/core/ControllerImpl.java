package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static catHouse.common.ExceptionMessages.*;
import static catHouse.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toyRepository;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = createHouse(type, name);
        this.houses.putIfAbsent(name, house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    private static House createHouse(String type, String name) {
        if (type.equals("ShortHouse")) {
            return new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            return new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
    }

    @Override
    public String buyToy(String type) {
        Toy toy = createToy(type);
        this.toyRepository.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    private static Toy createToy(String type) {
        if (type.equals("Ball")) {
            return new Ball();
        } else if (type.equals("Mouse")) {
            return new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toyRepository.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(
                String.format(NO_TOY_FOUND, toyType)
            );
        }

        House house = this.houses.get(houseName);
        house.buyToy(toy);
        this.toyRepository.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = createCat(catType, catName, catBreed, price);
        House house = this.houses.get(houseName);

        String houseType = house.getClass().getSimpleName();

        boolean isShorthairCatSuitable = catType.equals("ShorthairCat") && houseType.equals("ShortHouse");
        boolean isLonghairCatSuitable = catType.equals("LonghairCat") && houseType.equals("LongHouse");

        String output;

        if (isShorthairCatSuitable || isLonghairCatSuitable) {
            house.addCat(cat);
            output = String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            output = UNSUITABLE_HOUSE;
        }

        return output;
    }

    private static Cat createCat(String catType, String catName, String catBreed, double price) {
        if (catType.equals("ShorthairCat")) {
            return new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            return new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.get(houseName);
        house.feeding();
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.get(houseName);

        double catsPriceSum = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysPriceSum = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double totalValue = catsPriceSum + toysPriceSum;

        return String.format(VALUE_HOUSE, houseName, totalValue);
    }

    @Override
    public String getStatistics() {
        return this.houses.values().stream()
                .map(House::getStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
