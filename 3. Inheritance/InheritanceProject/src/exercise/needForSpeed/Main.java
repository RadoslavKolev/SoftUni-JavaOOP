package exercise.needForSpeed;

import exercise.needForSpeed.cars.Car;
import exercise.needForSpeed.cars.FamilyCar;
import exercise.needForSpeed.cars.SportCar;
import exercise.needForSpeed.motorcycles.CrossMotorcycle;
import exercise.needForSpeed.motorcycles.Motorcycle;
import exercise.needForSpeed.motorcycles.RaceMotorcycle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(150.26, 100);
        FamilyCar familyCar = new FamilyCar(300.50, 110);
        SportCar sportCar = new SportCar(200.65, 240);

        Motorcycle motorcycle = new Motorcycle(80.02, 70);
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(60.50, 300);
        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(80.43, 65);

        car.drive(100.65);
        familyCar.drive(100.65);
        sportCar.drive(100.65);
        motorcycle.drive(100.65);
        raceMotorcycle.drive(100.65);
        crossMotorcycle.drive(100.65);
    }
}
