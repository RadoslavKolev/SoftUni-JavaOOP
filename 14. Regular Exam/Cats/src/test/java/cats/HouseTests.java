package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {
    private House house;

    @Before
    public void setUp() {
        this.house = new House("Rose Cottage", 2);
    }

    // 1.1 Test Constructor - Happy path
    @Test
    public void test_Constructor_SetsDataCorrectly() {
        String houseName = this.house.getName();
        int houseCapacity = this.house.getCapacity();

        assertEquals("Rose Cottage", houseName);
        assertEquals(2, houseCapacity);
    }

    // 1.2. Test setName() throws exception when the name is null
    @Test(expected = NullPointerException.class)
    public void test_SetName_ThrowsException_WhenPassingNull() {
        House house = new House(null, 5);
        assertNull(house.getName());
    }

    // 1.3. Test setName() throws exception when the name is whitespace
    @Test(expected = NullPointerException.class)
    public void test_SetName_ThrowsException_WhenPassingWhitespace() {
        House house = new House("       ", 5);
        assertEquals("      ", house.getName());
    }

    // 1.4. Test setCapacity() throws exception when the capacity is lower than 0
    @Test(expected = IllegalArgumentException.class)
    public void test_SetCapacity_ThrowsException_WhenValueIsLowerThanZero() {
        new House("Rose Cottage", -5);
    }

    // 2.1 Test addCat() with correct data
    @Test
    public void test_AddCat_WithCorrectData() {
        int initialSize = 0;
        assertEquals(initialSize, this.house.getCount());

        this.house.addCat(new Cat("Persian"));
        assertEquals(initialSize + 1, this.house.getCount());

        this.house.addCat(new Cat("Persian"));
        assertEquals(initialSize + 2, this.house.getCount());
    }

    // 2.2. Test if addCat() throws exception when reaches its capacity
    @Test(expected = IllegalArgumentException.class)
    public void test_AddCat_ThrowsException_WhenReachesCapacity() {
        this.house.addCat(new Cat("Persian"));
        this.house.addCat(new Cat("Britain"));
        this.house.addCat(new Cat("Normal"));
    }

    // 3.1. Test if removeCat() removes cat correctly
    @Test
    public void test_RemoveCat_RemovesCatCorrectly() {
        this.house.addCat(new Cat("Persian"));
        this.house.addCat(new Cat("Britain"));
        int catsCount = this.house.getCount();

        this.house.removeCat("Persian");

        assertEquals(catsCount - 1, this.house.getCount());
    }

    // 3.2 Test if removeCat() throws exception when no cat is found
    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveCat_ThrowsException_WhenNoCatIsFound() {
        this.house.addCat(new Cat("Persian"));
        this.house.addCat(new Cat("Britain"));
        int catsCount = this.house.getCount();

        this.house.removeCat("Normal");

        assertEquals(catsCount, this.house.getCount());
    }

    // 4.1 Test if catForSale() returns the correct cat
    @Test
    public void test_CatForSale_ReturnsTheCorrectCat() {
        this.house.addCat(new Cat("Persian"));
        this.house.addCat(new Cat("Britain"));

        Cat cat = this.house.catForSale("Persian");

        assertEquals("Persian", cat.getName());
        assertFalse(cat.isHungry());
    }

    // 4.2. Test if catForSale() throws exception when no cat is found
    @Test(expected = IllegalArgumentException.class)
    public void test_CatForSale_ThrowsException_WhenNoCatIsFound() {
        this.house.addCat(new Cat("Persian"));
        this.house.addCat(new Cat("Britain"));

        Cat cat = this.house.catForSale("Normal");
        assertNull(cat);
    }

    // 5. Test if statistics() will return the correct output
    @Test
    public void test_Statistics_ReturnsTheCorrectOutput() {
        final String expectedOutput = "The cat Persian, Britain is in the house Rose Cottage!";

        this.house.addCat(new Cat("Persian"));
        this.house.addCat(new Cat("Britain"));

        String output = this.house.statistics();

        assertEquals(expectedOutput, output);
    }


}
