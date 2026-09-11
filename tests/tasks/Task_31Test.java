package tests.tasks;

import org.junit.jupiter.api.Test;
import tasks.Task_31;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task_31Test {

    @Test
    void findsPerfectNumberContainingDigitOneOrThree() {
        // 6, 28, 496, 8128 - совершенные числа; только 8128 содержит цифру 1
        List<Integer> array = Arrays.asList(6, 28, 496, 8128);
        assertEquals(List.of(8128), Task_31.parse(array));
    }

    @Test
    void perfectNumbersWithoutDigit1Or3AreExcluded() {
        List<Integer> array = Arrays.asList(6, 28, 496);
        assertTrue(Task_31.parse(array).isEmpty());
    }

    @Test
    void nonPerfectNumbersWithDigit1Or3AreExcluded() {
        // 13, 31, 100 содержат нужные цифры, но не совершенные
        List<Integer> array = Arrays.asList(13, 31, 100);
        assertTrue(Task_31.parse(array).isEmpty());
    }

    @Test
    void singleDigitOne_isNeverPerfect() {
        assertTrue(Task_31.parse(List.of(1)).isEmpty());
    }

    @Test
    void nonNaturalArray_throwsException() {
        List<Integer> array = Arrays.asList(6, -28);
        assertThrows(IllegalArgumentException.class, () -> Task_31.parse(array));
    }

    @Test
    void zeroInArray_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Task_31.parse(List.of(0, 6)));
    }

    @Test
    void emptyArray_returnsEmptyResult() {
        assertTrue(Task_31.parse(List.of()).isEmpty());
    }
}
