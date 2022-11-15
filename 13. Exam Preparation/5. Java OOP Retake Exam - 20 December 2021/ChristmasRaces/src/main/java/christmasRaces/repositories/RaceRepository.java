package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private final Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public void add(Race model) {
        this.races.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.races.remove(model);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }

    @Override
    public Race getByName(String name) {
        return this.races.stream()
                .filter(race -> race.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
