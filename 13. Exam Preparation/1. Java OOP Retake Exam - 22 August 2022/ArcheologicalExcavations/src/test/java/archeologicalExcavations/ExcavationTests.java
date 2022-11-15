package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {
    private Excavation excavation;

    @Before
    public void setUp() {
        this.excavation = new Excavation("Gold", 3);
    }

    // 1.1. Test if setName() sets the name correctly
    @Test
    public void test_SetName_SetsTheNameCorrectly() {
        String excavationName = this.excavation.getName();
        assertEquals("Gold", excavationName);
    }

    // 1.2. Test if setName() throws exception when passing null
    @Test(expected = NullPointerException.class)
    public void test_SetName_ThrowsException_WhenPassingNull() {
        Excavation excavation = new Excavation(null, 3);
    }

    // 1.3. Test if setName() throws exception when the name is only whitespace
    @Test(expected = NullPointerException.class)
    public void test_SetName_ThrowsException_WhenPassingWhitespace() {
        Excavation excavation = new Excavation("        ", 3);
    }

    // 2.1. Test if setCapacity() sets the capacity correctly
    @Test
    public void test_SetCapacity_SetsTheCapacityCorrectly() {
        int capacity = this.excavation.getCapacity();
        assertEquals(3, capacity);
    }

    // 2.2. Test if setCapacity() throws exception when passing negative value
    @Test(expected = IllegalArgumentException.class)
    public void test_SetCapacity_ThrowsException_WhenPassingNegativeValue() {
        Excavation excavation = new Excavation("Gold", -10);
    }

    // 3.1. Test if addArchaeologist() will add successfully to the collection
    @Test
    public void test_AddArchaeologist_AddsSuccessfullyToCollection() {
        this.excavation.addArchaeologist(new Archaeologist("Rado", 100));
        this.excavation.addArchaeologist(new Archaeologist("Peter", 90));
        assertEquals(2, this.excavation.getCount());
    }

    // 3.2. Test if addArchaeologist() will throw exception when there is no more capacity
    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_ThrowsException_WhenReachingCapacity() {
        this.excavation.addArchaeologist(new Archaeologist("Rado", 100));
        this.excavation.addArchaeologist(new Archaeologist("Peter", 90));
        this.excavation.addArchaeologist(new Archaeologist("George", 80));
        this.excavation.addArchaeologist(new Archaeologist("Ivan", 100));
    }

    // 3.3. Test if addArchaeologist() will throw exception when such archaeologist exists
    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_ThrowsException_WhenSuchArchaeologistExists() {
        this.excavation.addArchaeologist(new Archaeologist("Rado", 100));
        this.excavation.addArchaeologist(new Archaeologist("Rado", 70));
    }

    // 4.1. Test if removeArchaeologist() will remove archaeologist successfully
    @Test
    public void test_RemoveArchaeologist_RemovesEntitySuccessfully() {
        this.excavation.addArchaeologist(new Archaeologist("Rado", 100));
        this.excavation.addArchaeologist(new Archaeologist("Peter", 90));

        assertTrue(this.excavation.removeArchaeologist("Rado"));
        assertEquals(1, this.excavation.getCount());
    }

    // 4.2. Test if removeArchaeologist() will return null when no such archaeologist exists
    @Test
    public void test_RemoveArchaeologist_ReturnsNull_WhenNoSuchArchaeologistExists() {
        this.excavation.addArchaeologist(new Archaeologist("Rado", 100));
        this.excavation.addArchaeologist(new Archaeologist("Peter", 90));

        assertFalse(this.excavation.removeArchaeologist("George"));
        assertEquals(2, this.excavation.getCount());
    }

    // 5. Test if getCount() will return the correct size
    @Test
    public void test_GetCount_ReturnsTheCorrectSize() {
        assertEquals(0, this.excavation.getCount());
        this.excavation.addArchaeologist(new Archaeologist("Rado", 100));
        this.excavation.addArchaeologist(new Archaeologist("Peter", 90));
        assertEquals(2, this.excavation.getCount());
    }
}
