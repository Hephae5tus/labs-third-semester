package by.bsu.filipchick;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComplexTest {
    private static final double DELTA = 1e-9;

    @Test
    void modulusOfThreeFourIsFive() {
        assertEquals(5, new Complex(3, 4).modulus(), DELTA);
    }

    @Test
    void modulusOfZeroIsZero() {
        assertEquals(0, new Complex(0, 0).modulus(), DELTA);
    }

    @Test
    void subtractsComponentWise() {
        Complex difference = new Complex(4, -1).subtract(new Complex(1, 2));

        assertEquals(3, difference.getReal(), DELTA);
        assertEquals(-3, difference.getImaginary(), DELTA);
    }

    @Test
    void subtractRejectsNull() {
        Complex value = new Complex(1, 0);

        assertThrows(NullPointerException.class, () -> value.subtract(null));
    }
}
