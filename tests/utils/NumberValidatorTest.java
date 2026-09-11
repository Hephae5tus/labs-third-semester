package tests.utils;

import org.junit.jupiter.api.Test;
import utils.NumberValidator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @Test
    void allPositiveNumbers_returnsTrue() {
        List<Integer> array = Arrays.asList(1, 5, 100, 42);
        assertTrue(NumberValidator.isArrayNatural(array));
    }

    @Test
    void containsZero_returnsFalse() {
        List<Integer> array = Arrays.asList(1, 0, 5);
        assertFalse(NumberValidator.isArrayNatural(array));
    }

    @Test
    void containsNegative_returnsFalse() {
        List<Integer> array = Arrays.asList(1, -5, 5);
        assertFalse(NumberValidator.isArrayNatural(array));
    }

    @Test
    void emptyArray_returnsTrue() {
        // По коду пустой массив натуральным не является нарушением - цикл просто не выполняется
        assertTrue(NumberValidator.isArrayNatural(Collections.emptyList()));
    }

    @Test
    void singleNegativeElement_returnsFalse() {
        assertFalse(NumberValidator.isArrayNatural(Collections.singletonList(-1)));
    }

    @Test
    void negativeIsCheckedBeforeLaterElements_shortCircuitsCorrectly() {
        // Первый же неположительный элемент должен вернуть false, даже если дальше все ок
        List<Integer> array = Arrays.asList(-1, 2, 3, 4);
        assertFalse(NumberValidator.isArrayNatural(array));
    }

    @Test
    void constructor_isPrivateAndThrows() throws Exception {
        Constructor<NumberValidator> constructor = NumberValidator.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(UnsupportedOperationException.class, ex.getCause());
    }
}
