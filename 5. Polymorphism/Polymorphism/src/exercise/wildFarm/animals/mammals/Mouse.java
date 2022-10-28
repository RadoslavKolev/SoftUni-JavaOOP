package exercise.wildFarm.animals.mammals;

import exercise.wildFarm.food.Food;
import exercise.wildFarm.food.Vegetable;

public class Mouse extends Mammal{
    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Mouse", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        } else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
}
