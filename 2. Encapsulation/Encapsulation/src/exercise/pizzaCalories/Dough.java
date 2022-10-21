package exercise.pizzaCalories;

import java.util.Arrays;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        boolean isValid = Arrays
                .stream(FlourTypes.values())
                .anyMatch(type -> type.name().equals(flourType));

        if (!isValid) {
            String exceptionMessage = "Invalid type of dough.";
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        boolean isValid = Arrays
                .stream(BakingTechniques.values())
                .anyMatch(technique -> technique.name().equals(bakingTechnique));

        if (!isValid) {
            String exceptionMessage = "Invalid type of dough.";
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            String exceptionMessage = "Dough weight should be in the range [1..200].";
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        FlourTypes flourTypeEnum = FlourTypes.valueOf(this.flourType);
        BakingTechniques bakingTechniqueEnum = BakingTechniques.valueOf(this.bakingTechnique);

        double flourTypeModifier = flourTypeEnum.getModifier();
        double bakingTechniqueModifier = bakingTechniqueEnum.getModifier();

        return (2 * this.weight) * flourTypeModifier * bakingTechniqueModifier;
    }
}
