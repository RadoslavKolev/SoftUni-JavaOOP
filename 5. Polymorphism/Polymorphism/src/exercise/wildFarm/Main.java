package exercise.wildFarm;

import exercise.wildFarm.animals.Animal;
import exercise.wildFarm.animals.mammals.Mouse;
import exercise.wildFarm.animals.mammals.Zebra;
import exercise.wildFarm.animals.mammals.felimes.Cat;
import exercise.wildFarm.animals.mammals.felimes.Tiger;
import exercise.wildFarm.food.Food;
import exercise.wildFarm.food.Meat;
import exercise.wildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();

        fillLists(scanner, animals, foodList);
        feedAnimals(animals, foodList);
        printAnimals(animals);
    }

    private static void fillLists(Scanner scanner, List<Animal> animals, List<Food> foodList) {
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            readAnimalInfo(animals, tokens);

            input = scanner.nextLine();
            tokens = input.split("\\s+");

            readFoodInfo(foodList, tokens);

            input = scanner.nextLine();
        }
    }

    private static void readAnimalInfo(List<Animal> animals, String[] tokens) {
        String animalType = tokens[0];
        String animalName = tokens[1];
        Double animalWeight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];
        String breed = "";

        if (animalType.equals("Cat")) {
            breed = tokens[4];
        }

        Animal animal = getAnimal(animalType, animalName, animalWeight, livingRegion, breed);
        animals.add(animal);
    }

    private static Animal getAnimal(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        return switch (animalType) {
            case "Mouse" -> new Mouse(animalName, animalWeight, livingRegion);
            case "Cat" -> new Cat(animalName, animalWeight, livingRegion, breed);
            case "Tiger" -> new Tiger(animalName, animalWeight, livingRegion);
            case "Zebra" -> new Zebra(animalName, animalWeight, livingRegion);
            default -> null;
        };
    }

    private static void readFoodInfo(List<Food> foodList, String[] tokens) {
        String foodType = tokens[0];
        Integer foodQuantity = Integer.parseInt(tokens[1]);

        Food food = getFood(foodType, foodQuantity);
        foodList.add(food);
    }

    private static Food getFood(String foodType, Integer foodQuantity) {
        return switch (foodType) {
            case "Vegetable" -> new Vegetable(foodQuantity);
            case "Meat" -> new Meat(foodQuantity);
            default -> null;
        };
    }

    private static void feedAnimals(List<Animal> animals, List<Food> foodList) {
        int size = animals.size();

        for (int i = 0; i < size; i++) {
            Animal currentAnimal = animals.get(i);
            Food currentFood = foodList.get(i);

            currentAnimal.makeSound();
            currentAnimal.eat(currentFood);
        }
    }

    private static void printAnimals(List<Animal> animals) {
        animals.forEach(System.out::println);
    }
}
