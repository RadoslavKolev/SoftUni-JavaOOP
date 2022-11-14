package exercise.p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private final static Integer[] TEST_NUMBERS = {5, 8, 21, 68, 81, -5};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(TEST_NUMBERS);
    }

    // 1. Test Constructor
    // 1.1. Happy Path -> everything works fine and DB is created
    @Test
    public void test_CreateDatabase() {
        Integer[] dbElements = database.getElements();

        // Test if elements are the same and with equal length
        assertArrayEquals(TEST_NUMBERS, dbElements);
    }

    // 1.2. Failed validation -> too few arguments
    @Test(expected = OperationNotSupportedException.class)
    public void test_CreateDatabase_WithTooFewArguments()
            throws OperationNotSupportedException {
        final int EXPECTED_SIZE = 0;
        Database database = new Database();
        assertEquals(EXPECTED_SIZE, database.getElements().length);
    }

    // 1.3. Failed validation -> too many arguments
    @Test(expected = OperationNotSupportedException.class)
    public void test_CreateDatabase_WithTooManyArguments()
            throws OperationNotSupportedException {
        final Integer[] TEST_NUMBERS = {
                5, 8, 21, 68, 81, -5, 1, 2, 3, 4,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29
        };

        final int EXPECTED_SIZE = TEST_NUMBERS.length;

        Database database = new Database(TEST_NUMBERS);
        assertEquals(EXPECTED_SIZE, database.getElements().length);
    }

    // 2. Test add operation
    // 2.1. Happy path -> element added successfully
    @Test
    public void test_AddElement_ToArray()
            throws OperationNotSupportedException {
        final int INITIAL_SIZE = database.getElements().length;
        final int NUMBER_TO_ADD = 12;

        database.add(NUMBER_TO_ADD);
        Integer[] dbElements = database.getElements();
        int lastElementFromDB = dbElements[dbElements.length - 1];

        // This will check if we actually added an element
        // If the last element was initially 12, and we check for the last element only
        // The test will pass
        assertEquals(INITIAL_SIZE + 1, database.getElements().length);
        assertEquals(NUMBER_TO_ADD, lastElementFromDB);
    }

    // 2.2. Test if we add null element, throws an exception
    @Test(expected = OperationNotSupportedException.class)
    public void test_AddNullElement_ToArray()
            throws OperationNotSupportedException {
        database.add(null);
    }

    // 3. Test remove operation
    // 3.1. Happy path -> last element is removed successfully
    @Test
    public void test_RemoveLastElement()
            throws OperationNotSupportedException {
        final int INITIAL_SIZE = database.getElements().length;

        database.remove();
        Integer[] dbElements = database.getElements();

        // Test if the size decreased
        assertEquals(INITIAL_SIZE - 1, dbElements.length);

        // Test if the second last element is now the last element
        int secondToLastBeforeRemoval = TEST_NUMBERS[TEST_NUMBERS.length - 2];
        int lastElementAfterRemoval = dbElements[dbElements.length - 1];

        assertEquals(secondToLastBeforeRemoval, lastElementAfterRemoval);
    }

    // 3.2. Remove from empty Database -> throws OperationNotSupportedException
    @Test(expected = OperationNotSupportedException.class)
    public void test_RemoveFromEmptyDatabase()
            throws OperationNotSupportedException {
        Database emptyDatabase = new Database();
        emptyDatabase.remove();
    }

    // 3.3. Empty all elements and add additional remove
    @Test(expected = OperationNotSupportedException.class)
    public void test_EmptyAllElements_AndThenRemove()
            throws OperationNotSupportedException {
        // clear the whole array
        for (int i = 0; i < TEST_NUMBERS.length; i++) {
            database.remove();
        }

        // remove from empty array
        database.remove();
    }
}