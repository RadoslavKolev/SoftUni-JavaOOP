package exercise.pizzaCalories;

public enum BakingTechniques {
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private final double modifier;

    BakingTechniques(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
