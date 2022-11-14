package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    private final static double INITIAL_KG = 2.50;
    private final static double INCREASING_KG_VALUE = 7.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KG, price);
    }

    @Override
    public void eat() {
        this.setKg(this.getKg() + INCREASING_KG_VALUE);
    }
}
