package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer {
    private final static int INITIAL_ENERGY = 100;

    public Geologist(String name) {
        super(name, INITIAL_ENERGY);
    }
}
