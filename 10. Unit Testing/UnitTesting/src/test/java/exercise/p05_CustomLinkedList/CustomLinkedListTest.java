package exercise.p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setUp() {
        this.customLinkedList = new CustomLinkedList<>();
    }

    // 1. Test add()
    @Test
    public void test_Add_WithEmptyList() {
        customLinkedList.add("Peter");
        assertEquals("Peter", customLinkedList.get(0));
    }

    @Test
    public void test_Add_WithNonEmptyList() {
        customLinkedList.add("Peter");
        customLinkedList.add("Ivan");
        assertEquals("Ivan", customLinkedList.get(1));
    }

    // 2. Test get()
    @Test
    public void test_GetElement() {
        final String[] ELEMENTS = {"Peter", "Ivan", "George"};

        customLinkedList.add("Peter");
        customLinkedList.add("Ivan");
        customLinkedList.add("George");

        for (int i = 0; i < 2; i++) {
            String currentListElement = customLinkedList.get(i);
            assertEquals(ELEMENTS[i], currentListElement);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Get_ThrowsException_WhenIndexIsOutOfBounds_Below() {
        customLinkedList.add("Peter");
        customLinkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Get_ThrowsException_WhenIndexIsOutOfBounds_Above() {
        customLinkedList.add("Peter");
        customLinkedList.get(2);
    }
}