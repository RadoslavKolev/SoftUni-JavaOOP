package exercise.wildFarm.animals.mammals.felimes;

import exercise.wildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, "Cat", animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format(
                "%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                this.breed,
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten()
        );
    }
}
