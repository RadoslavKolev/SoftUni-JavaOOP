package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ExceptionMessages.*;
import static goldDigger.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    private int spotCount;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;

        switch (kind) {
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        this.discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        this.spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(
                String.format(DISCOVERER_DOES_NOT_EXIST, discovererName)
            );
        }

        this.discovererRepository.remove(discoverer);
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        final int TARGET_ENERGY = 45;

        List<Discoverer> availableDiscoverers = this.discovererRepository.getCollection().stream()
                .filter(discoverer -> discoverer.getEnergy() > TARGET_ENERGY)
                .collect(Collectors.toList());

        if (availableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = this.spotRepository.byName(spotName);

        Operation operation = new OperationImpl();
        operation.startOperation(spot, availableDiscoverers);

        long excluded = availableDiscoverers.stream()
                .filter(d -> d.getEnergy() == 0)
                .count();

        this.spotCount++;

        return String.format(INSPECT_SPOT, spotName, excluded);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(FINAL_SPOT_INSPECT, this.spotCount));
        builder.append(System.lineSeparator());
        builder.append(FINAL_DISCOVERER_INFO);

        Collection<Discoverer> discoverers = this.discovererRepository.getCollection();

        for (Discoverer discoverer : discoverers) {
            builder.append(System.lineSeparator());
            builder.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()));
            builder.append(System.lineSeparator());
            builder.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()));
            builder.append(System.lineSeparator());

            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                builder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"));
            } else {
                builder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, String.join(
                        FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits()))
                );
            }
        }

        return builder.toString().trim();
    }
}
