package tests.tasks;

import org.junit.jupiter.api.Test;
import tasks.Task_7;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task_7Test {

    @Test
    void findsPValuedNumbersWithFewUniqueDigits() {
        // p=3, k=2: 123 -> {1,2,3} 3 разных цифры (исключить),
        // 112 -> {1,2} 2 разных (включить), 221 -> {2,1} 2 разных (включить)
        List<Integer> array = Arrays.asList(123, 112, 221, 55);
        List<Integer> result = Task_7.parse(array, 3, 2);
        assertEquals(List.of(112, 221), result);
    }

    @Test
    void excludesNumbersWithTooManyUniqueDigits() {
        List<Integer> array = List.of(123, 456);
        assertTrue(Task_7.parse(array, 3, 2).isEmpty());
    }

    @Test
    void ignoresNumbersWithWrongDigitCount() {
        List<Integer> array = List.of(11, 111, 1111);
        List<Integer> result = Task_7.parse(array, 3, 1);
        assertEquals(List.of(111), result);
    }

    @Test
    void repeatedDigitsCountOnceTowardsUniqueLimit() {
        // 1113 -> уникальные цифры {1,3} = 2, при k=2 должно пройти
        List<Integer> array = List.of(1113);
        assertEquals(List.of(1113), Task_7.parse(array, 4, 2));
    }

    @Test
    void kEqualToP_throwsException() {
        List<Integer> array = List.of(111);
        assertThrows(IllegalArgumentException.class, () -> Task_7.parse(array, 3, 3));
    }

    @Test
    void kGreaterThanP_throwsException() {
        List<Integer> array = List.of(111);
        assertThrows(IllegalArgumentException.class, () -> Task_7.parse(array, 2, 5));
    }

    @Test
    void kLessThanOne_throwsException() {
        List<Integer> array = List.of(111);
        assertThrows(IllegalArgumentException.class, () -> Task_7.parse(array, 3, 0));
    }

    @Test
    void nonNaturalArray_throwsException() {
        List<Integer> array = Arrays.asList(123, -45);
        assertThrows(IllegalArgumentException.class, () -> Task_7.parse(array, 3, 2));
    }

    @Test
    void zeroInArray_throwsException() {
        List<Integer> array = Arrays.asList(123, 0);
        assertThrows(IllegalArgumentException.class, () -> Task_7.parse(array, 3, 2));
    }

    @Test
    void emptyArray_returnsEmptyResult() {
        assertTrue(Task_7.parse(List.of(), 3, 1).isEmpty());
    }
}
