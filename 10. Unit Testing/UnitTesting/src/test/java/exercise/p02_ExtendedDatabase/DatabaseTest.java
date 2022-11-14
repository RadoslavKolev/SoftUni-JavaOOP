package exercise.p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private final static Person[] PERSONS = {
        new Person(1, "Todor"),
        new Person(2, "Radoslav"),
        new Person(3, "Maria"),
        new Person(4, "Ivan"),
        new Person(5, "Alexander"),
        new Person(6, "Ihsan"),
        new Person(7, "Musa"),
        new Person(8, "Rosen"),
        new Person(9, "Denislav")
    };
    private Database database;

    @Before
    public void setUp() throws Exception {
        this.database = new Database(PERSONS);
    }

    // 1. Constructor Tests
    @Test
    public void test_CreateDatabase_WithPersons() {
        Person[] dbElements = database.getElements();

        // Test if arrays are the same
        assertArrayEquals(PERSONS, dbElements);
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
        final Person[] tooManyPersons = {
                new Person(1, "Todor"),
                new Person(2, "Radoslav"),
                new Person(3, "Maria"),
                new Person(4, "Ivan"),
                new Person(5, "Aleksander"),
                new Person(6, "Ishan"),
                new Person(7, "Musa"),
                new Person(8, "Rosen"),
                new Person(9, "Denislav"),
                new Person(10, "Petur"),
                new Person(11, "Yoan"),
                new Person(12, "Maria"),
                new Person(13, "Petya"),
                new Person(14, "Mihail"),
                new Person(15, "Stoyan"),
                new Person(16, "Kiril"),
                new Person(17, "Svetlin")
        };

        final int EXPECTED_SIZE = tooManyPersons.length;

        Database database = new Database(tooManyPersons);
        assertEquals(EXPECTED_SIZE, database.getElements().length);
    }

    // 2. Test add functionality
    // 2.1. Happy path -> add person successfully
    @Test
    public void test_AddPersonToDatabase()
            throws OperationNotSupportedException {
        Person person = new Person(10, "Yoan");
        database.add(person);

        // Check if the size has changed
        Person[] dbPersons = database.getElements();
        assertEquals(PERSONS.length + 1, dbPersons.length);

        // Check if the last element is Yoan with id 10
        Person lastPersonFromDB = dbPersons[dbPersons.length - 1];
        assertEquals(person.getId(), lastPersonFromDB.getId());
        assertEquals(person.getUsername(), lastPersonFromDB.getUsername());
    }
    // 2.2. Test if we try to add not initialized Person
    @Test(expected = OperationNotSupportedException.class)
    public void test_AddMethod_WithNoArguments()
            throws OperationNotSupportedException {
        database.add(null);
    }

    // 3. Test remove()
    // 3.1. Removed last Person successfully
    @Test
    public void test_RemoveLastPerson()
            throws OperationNotSupportedException {
        final int INITIAL_SIZE = database.getElements().length;

        database.remove();
        Person[] dbElements = database.getElements();

        // Test if the size decreased
        assertEquals(INITIAL_SIZE - 1, dbElements.length);

        // Test if the second last element is now the last element
        Person secondToLastBeforeRemoval = PERSONS[PERSONS.length - 2];
        Person lastElementAfterRemoval = dbElements[dbElements.length - 1];

        assertEquals(secondToLastBeforeRemoval.getId(), lastElementAfterRemoval.getId());
        assertEquals(secondToLastBeforeRemoval.getUsername(), lastElementAfterRemoval.getUsername());
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
    public void test_RemoveCommand_WhenThereAreNoElements()
            throws OperationNotSupportedException {
        // clear the whole array
        for (int i = 0; i < PERSONS.length; i++) {
            database.remove();
        }

        // remove from empty array
        database.remove();
    }

    // 4. Test findByUsername()
    // 4.1. Pass valid username
    @Test
    public void test_FindByUsername_WithValidData()
            throws OperationNotSupportedException {
        Person expectedPerson = new Person(2, "Radoslav");
        Person returnedPerson = database.findByUsername("Radoslav");

        assertEquals(expectedPerson.getId(), returnedPerson.getId());
        assertEquals(expectedPerson.getUsername(), returnedPerson.getUsername());
    }

    // 4.2. Test when there is no such Person
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_ThrowsException_WithInvalidUsername()
            throws OperationNotSupportedException {
        database.findByUsername("Rado");
    }

    // 4.3. Test when there are more than one Person
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_ThrowsException_WhenUsernamesAreNotUnique()
            throws OperationNotSupportedException {
        database.add(new Person(10, "Radoslav"));
        database.findByUsername("Radoslav");
    }

    // 4.4. Pass null
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_ThrowsException_WhenPassingNull()
            throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    // 4.5. Empty database
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_ThrowsException_WhenDatabaseIsEmpty()
            throws OperationNotSupportedException {
        Database emptyDatabase = new Database();
        emptyDatabase.findByUsername("Rado");
    }

    // 5. Test findById
    // 5.1. Pass valid ID
    @Test
    public void test_FindByID_WithValidData()
            throws OperationNotSupportedException {
        Person expectedPerson = new Person(2, "Radoslav");
        Person returnedPerson = database.findById(2);

        assertEquals(expectedPerson.getId(), returnedPerson.getId());
        assertEquals(expectedPerson.getUsername(), returnedPerson.getUsername());
    }

    // 5.2. Pass invalid ID
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByID_ThrowsException_WithInvalidID()
            throws OperationNotSupportedException {
        database.findById(10);
    }

    // 5.3. Found more than one id
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByID_ThrowsException_WhenIDsAreNotUnique()
            throws OperationNotSupportedException {
        database.add(new Person(1, "Dimitar"));
        database.findById(1);
    }

    // 5.4. Empty database
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByID_ThrowsException_WhenDatabaseIsEmpty()
            throws OperationNotSupportedException {
        Database emptyDatabase = new Database();
        emptyDatabase.findById(2);
    }
}