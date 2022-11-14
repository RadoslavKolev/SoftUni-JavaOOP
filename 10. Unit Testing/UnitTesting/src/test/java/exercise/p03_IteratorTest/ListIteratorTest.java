package exercise.p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private final static String[] ELEMENTS = {"Angel", "Yoan", "Peter"};

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ELEMENTS);
    }

    // 1. Test Constructor with passing null data
    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ThrowsException_WhenPassingNull()
            throws OperationNotSupportedException {
        new ListIterator(null);
    }

    // 2. Test hasNext()
    @Test
    public void test_HasNextElement() {
        assertTrue(listIterator.hasNext());

        listIterator.move();    // Yoan
        assertTrue(listIterator.hasNext());

        listIterator.move();    // Peter
        assertFalse(listIterator.hasNext());
    }

    // 3. Test move()
    @Test
    public void test_MoveMethod() {
        assertTrue(listIterator.move());    // Yoan
        assertTrue(listIterator.move());    // Peter
        assertFalse(listIterator.move());   // No more elements (should return false)
    }

    // 4. Test print()
    // 4.1. Return element successfully
    @Test
    public void test_PrintCurrentElement() {
        int index = 0;

        while(listIterator.hasNext()) {
            assertEquals(ELEMENTS[index], listIterator.print());
            listIterator.move();
            index++;
        }
    }

    // 4.2. Test if List is empty
    @Test(expected = IllegalStateException.class)
    public void test_Print_ThrowsException_WhenListIsEmpty()
            throws OperationNotSupportedException {
        ListIterator emptyListIterator = new ListIterator();
        emptyListIterator.print();
    }
}