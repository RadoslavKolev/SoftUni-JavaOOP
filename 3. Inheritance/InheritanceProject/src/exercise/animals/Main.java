package exercise.animals;

import exercise.animals.cats.Cat;
import exercise.animals.cats.Kitten;
import exercise.animals.cats.Tomcat;
import exercise.animals.others.Dog;
import exercise.animals.others.Frog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!animalType.equals("Beast!")) {
            String[] animalInfo = scanner.nextLine().split("\\s+");

            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            Animal animal;

            try {
                // Enhanced switch doesn't work on Judge
                switch (animalType) {
                    case "Dog" -> animal = new Dog(name, age, gender);
                    case "Frog" -> animal = new Frog(name, age, gender);
                    case "Cat" -> animal = new Cat(name, age, gender);
                    case "Kitten" -> animal = new Kitten(name, age);
                    case "Tomcat" -> animal = new Tomcat(name, age);
                    default -> throw new IllegalArgumentException("No such animal type!");
                }

                System.out.println(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalType = scanner.nextLine();
        }
    }
}
