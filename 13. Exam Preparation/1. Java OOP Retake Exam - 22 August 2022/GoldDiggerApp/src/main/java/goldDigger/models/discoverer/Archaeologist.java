package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer {
    private final static int INITIAL_ENERGY = 60;

    public Archaeologist(String name) {
        super(name, INITIAL_ENERGY);
    }
}
