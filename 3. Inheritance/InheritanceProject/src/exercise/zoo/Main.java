package exercise.zoo;

import exercise.zoo.mammals.Bear;
import exercise.zoo.mammals.Gorilla;
import exercise.zoo.reptiles.Lizard;
import exercise.zoo.reptiles.Snake;

public class Main {
    public static void main(String[] args) {
        Lizard lizard = new Lizard("George");
        Snake snake = new Snake("Mandingo");
        Gorilla gorilla = new Gorilla("King Kong");
        Bear bear = new Bear("Plamen");

        System.out.println(lizard.getName());
        System.out.println(snake.getName());
        System.out.println(gorilla.getName());
        System.out.println(bear.getName());
    }
}
