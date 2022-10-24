package lection.carShopExtended;

import lection.carShopExtended.cars.Audi;
import lection.carShopExtended.cars.Seat;
import lection.carShopExtended.interfaces.Car;
import lection.carShopExtended.interfaces.Rentable;
import lection.carShopExtended.interfaces.Sellable;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.printf(
                "%s is %s color and have %s horse power%n",
                car.getModel(),
                car.getColor(),
                car.getHorsePower());

        System.out.println(car);
    }

}
