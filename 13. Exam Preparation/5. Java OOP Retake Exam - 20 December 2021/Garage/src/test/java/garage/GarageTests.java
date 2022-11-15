package garage;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {
    private Garage garage;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.garage.addCar(new Car("Volvo", 240, 3500.00));
        this.garage.addCar(new Car("Opel", 220, 2000.00));
        this.garage.addCar(new Car("BMW", 280, 5000.00));
    }

    // 1. Test if the returned list is unmodifiable
    @Test(expected = UnsupportedOperationException.class)
    public void test_GetCars_ReturnsUnmodifiableList() {
        List<Car> cars = this.garage.getCars();
        cars.add(new Car("Volvo", 240, 3500.00));
    }

    // 2. Test if the method returns the right count
    @Test
    public void test_GetCount_ReturnsTheRightAmount() {
        final int EXPECTED_SIZE = 3;
        int carsCount = this.garage.getCount();
        assertEquals(EXPECTED_SIZE, carsCount);
    }

    // 3.1. Test if addCar adds car successfully
    @Test
    public void test_AddCar_SuccessfullyInTheList() {
        int carsCount = this.garage.getCount();
        this.garage.addCar(new Car("Mercedes", 270, 6500.00));
        assertEquals(carsCount + 1, this.garage.getCount());

        List<Car> cars = this.garage.getCars();

        assertEquals("Mercedes", cars.get(3).getBrand());
        assertEquals(270, cars.get(3).getMaxSpeed());
        assertEquals(6500.00, cars.get(3).getPrice(), 0.00);
    }

    // 3.2. Test if addCar throws exception when Car is null
    @Test(expected = IllegalArgumentException.class)
    public void test_AddCar_ThrowsException_WhenPassingNull() {
        this.garage.addCar(null);
    }

    // 4.1. Test if findAllCarsWithMaxSpeedAbove returns the right data
    @Test
    public void test_FindAllCarsWithMaxSpeedAbove_ReturnsCorrectData() {
        List<Car> cars = this.garage.findAllCarsWithMaxSpeedAbove(230);
        cars.forEach(car -> assertTrue(car.getMaxSpeed() > 220));
    }

    // 4.2. Test if findAllCarsWithMaxSpeedAbove returns empty list when no car meets the condition
    @Test
    public void test_FindAllCarsWithMaxSpeedAbove_ReturnsEmptyList_WhenNoCarMeetsTheCondition() {
        List<Car> cars = this.garage.findAllCarsWithMaxSpeedAbove(300);
        assertEquals(0, cars.size());
    }

    // 4.3. Test if findAllCarsWithMaxSpeedAbove returns empty list when Garage is empty
    @Test
    public void test_FindAllCarsWithMaxSpeedAbove_ReturnsEmptyList_WhenGarageIsEmpty() {
        Garage emptyGarage = new Garage();
        List<Car> cars = emptyGarage.findAllCarsWithMaxSpeedAbove(300);
        assertEquals(0, cars.size());
    }

    // 5.1. Test if findAllCarsByBrand returns the right data
    @Test
    public void test_FindAllCarsByBrand_ReturnsCorrectData() {
        this.garage.addCar(new Car("Volvo", 250, 4000.00));
        List<Car> cars = this.garage.findAllCarsByBrand("Volvo");
        cars.forEach(car -> assertEquals("Volvo", car.getBrand()));
    }

    // 5.2. Test if findAllCarsByBrand returns empty list when no car meets the condition
    @Test
    public void test_FindAllCarsByBrand_ReturnsEmptyList_WhenNoCarMeetsTheCondition() {
        List<Car> cars = this.garage.findAllCarsByBrand("Toyota");
        assertEquals(0, cars.size());
    }

    // 5.3. Test if findAllCarsByBrand returns empty list when Garage is empty
    @Test
    public void test_FindAllCarsByBrand_ReturnsEmptyList_WhenGarageIsEmpty() {
        Garage emptyGarage = new Garage();
        List<Car> cars = emptyGarage.findAllCarsByBrand("Toyota");
        assertEquals(0, cars.size());
    }

    // 6.1. Test if getTheMostExpensiveCar() returns the most expensive car
    @Test
    public void test_GetTheMostExpensiveCar_ReturnsCorrectData() {
        Car theMostExpensiveCar = this.garage.getTheMostExpensiveCar();

        assertEquals("BMW", theMostExpensiveCar.getBrand());
        assertEquals(280, theMostExpensiveCar.getMaxSpeed());
        assertEquals(5000.00, theMostExpensiveCar.getPrice(), 0.00);
    }

    // 6.2. Test if getTheMostExpensiveCar() returns null when the list is empty
    @Test
    public void test_GetTheMostExpensiveCar_ReturnsNull_WhenListIsEmpty() {
        Garage emptyGarage = new Garage();
        assertNull(emptyGarage.getTheMostExpensiveCar());
    }
}