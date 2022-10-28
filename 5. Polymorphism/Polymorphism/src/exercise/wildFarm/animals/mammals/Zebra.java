package exercise.wildFarm.animals.mammals;

import exercise.wildFarm.food.Food;
import exercise.wildFarm.food.Vegetable;

public class Zebra extends Mammal{
    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Zebra", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("%ss are not eating that type of food!%n", super.getAnimalType());
        }
    }
}
