package exercise.p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    @Test
    public void testSort() {
        final int[] NUMBERS_TO_SORT = {9, -5, 6, 1, 12, 100};
        final int[] SORTED_NUMBERS = {-5, 1, 6, 9, 12, 100};

        Bubble.sort(NUMBERS_TO_SORT);
        assertArrayEquals(SORTED_NUMBERS, NUMBERS_TO_SORT);
    }
}