package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private final static int INITIAL_KILOGRAMS = 7;
    private final static int INCREASING_KILOGRAMS_VALUE = 1;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + INCREASING_KILOGRAMS_VALUE);
    }
}
