package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;
import static catHouse.common.ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_THE_CAT;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(this.cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(this.toys);
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream()
                .mapToInt(Toy::getSoftness)
                .sum();
    }

    // TODO: Possible error with >= or with the house he lives in
    // Added exception to ExceptionMessages (probably missed)
    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() >= capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_THE_CAT);
        }

        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    // TODO: Possible Error
    @Override
    public String getStatistics() {
        String catOutput = this.cats.isEmpty()
                ? "none"
                : this.cats.stream().map(Cat::getName).collect(Collectors.joining(" "));

        return String.format(
            "%s %s:%n" +
            "Cats: %s%n" +
            "Toys: %d Softness: %d",
            this.name,
            this.getClass().getSimpleName(),
            catOutput,
            this.toys.size(),
            this.sumSoftness()
        );
    }
}
