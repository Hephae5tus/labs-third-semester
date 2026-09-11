package tests.tasks;

import org.junit.jupiter.api.Test;
import tasks.Task_19;
import utils.DigitUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task_19Test {

    @Test
    void countsFourDigitNumbersWithMatchingDigitSum() {
        // 1234 -> сумма цифр 10, 4321 -> 10, 1111 -> 4
        List<Integer> filtered = Arrays.asList(1234, 4321, 1111);
        assertEquals(2, Task_19.parse(filtered, 10));
    }

    @Test
    void noMatches_returnsZero() {
        List<Integer> filtered = Arrays.asList(1111, 2222);
        assertEquals(0, Task_19.parse(filtered, 99));
    }

    @Test
    void negativeFourDigitNumbers_useAbsoluteValueForDigitSum() {
        // -1234 -> |1234| -> сумма цифр 1+2+3+4=10
        List<Integer> filtered = List.of(-1234);
        assertEquals(1, Task_19.parse(filtered, 10));
    }

    @Test
    void emptyList_returnsZero() {
        assertEquals(0, Task_19.parse(List.of(), 5));
    }

    @Test
    void allNumbersCanMatchSimultaneously() {
        List<Integer> filtered = Arrays.asList(1111, 2222, 1310);
        // все имеют сумму цифр = 4? 1111->4, 2222->8, 1310->1+3+1+0=5
        assertEquals(1, Task_19.parse(filtered, 4));
    }

    @Test
    void integrationWithDigitUtils_keepsOnlyFourDigitNumbers() {
        List<Integer> array = Arrays.asList(5, 55, 555, 5555, 55555, -5555);
        List<Integer> filtered = DigitUtils.filterByDigitsNumber(array, 4);
        assertEquals(Arrays.asList(5555, -5555), filtered);
        assertEquals(2, Task_19.parse(filtered, 20)); // 5+5+5+5=20 для обоих
    }
}
