package tests.utils;

import org.junit.jupiter.api.Test;
import utils.DigitUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DigitUtilsTest {

    @Test
    void filtersNumbersWithGivenDigitCount() {
        List<Integer> array = Arrays.asList(5, 42, 123, 4321, 99);
        List<Integer> result = DigitUtils.filterByDigitsNumber(array, 2);
        assertEquals(Arrays.asList(42, 99), result);
    }

    @Test
    void zeroCountsAsOneDigitNumber() {
        List<Integer> array = Arrays.asList(0, 5, 10);
        List<Integer> result = DigitUtils.filterByDigitsNumber(array, 1);
        assertEquals(Arrays.asList(0, 5), result);
    }

    @Test
    void negativeNumbers_signIsNotCountedAsDigit() {
        // -123 должно считаться трёхзначным, как и 123 - минус не цифра
        List<Integer> array = Arrays.asList(-123, 123, -45);
        List<Integer> result = DigitUtils.filterByDigitsNumber(array, 3);
        assertEquals(Arrays.asList(-123, 123), result);
    }

    @Test
    void noMatches_returnsEmptyList() {
        List<Integer> array = Arrays.asList(1, 22, 333);
        assertTrue(DigitUtils.filterByDigitsNumber(array, 5).isEmpty());
    }

    @Test
    void emptyInput_returnsEmptyList() {
        assertTrue(DigitUtils.filterByDigitsNumber(List.of(), 3).isEmpty());
    }

    @Test
    void preservesOriginalOrder() {
        List<Integer> array = Arrays.asList(99, 11, 5, 88, 100);
        List<Integer> result = DigitUtils.filterByDigitsNumber(array, 2);
        assertEquals(Arrays.asList(99, 11, 88), result);
    }

    @Test
    void constructor_isPrivateAndThrows() throws Exception {
        Constructor<DigitUtils> constructor = DigitUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(UnsupportedOperationException.class, ex.getCause());
    }
}
