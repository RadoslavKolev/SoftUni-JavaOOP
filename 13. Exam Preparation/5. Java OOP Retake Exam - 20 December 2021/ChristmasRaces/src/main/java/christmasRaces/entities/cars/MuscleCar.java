package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {
    private final static double CUBIC_CENTIMETERS = 5000.0;
    private final static int MIN_HORSEPOWER = 400;
    private final static int MAX_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    // Or we can make the setHorsePower() protected and override it here
    @Override
    protected void checkHorsePower(int horsePower) {
        if (horsePower < MIN_HORSEPOWER || horsePower > MAX_HORSEPOWER) {
            throw new IllegalArgumentException(
                String.format(INVALID_HORSE_POWER, horsePower)
            );
        }
    }
}
