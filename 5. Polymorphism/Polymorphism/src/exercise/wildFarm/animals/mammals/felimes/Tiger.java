package exercise.wildFarm.animals.mammals.felimes;

import exercise.wildFarm.food.Food;
import exercise.wildFarm.food.Meat;

public class Tiger extends Felime{
    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Tiger", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("%ss are not eating that type of food!%n", super.getAnimalType());
        }
    }
}
