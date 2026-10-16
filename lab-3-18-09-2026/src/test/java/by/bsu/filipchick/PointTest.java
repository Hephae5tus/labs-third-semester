package by.bsu.filipchick;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {
    private static final double DELTA = 1e-9;

    @Test
    void distanceToOriginOfZeroPointIsZero() {
        Point origin = new Point(new Complex(0, 0), 0);

        assertEquals(0, origin.distanceToOrigin(), DELTA);
    }

    @Test
    void distanceToOriginOfThreeFourZeroIsFive() {
        Point point = new Point(new Complex(3, 4), 0);

        assertEquals(5, point.distanceToOrigin(), DELTA);
    }

    @Test
    void distanceToOriginIncludesRealCoordinate() {
        assertEquals(13, new Point(new Complex(3, 4), 12).distanceToOrigin(), DELTA);
        assertEquals(5, new Point(0, 0, -5).distanceToOrigin(), DELTA);
    }

    @Test
    void distanceBetweenPointsUsesComplexAndRealParts() {
        Point a = new Point(new Complex(1, 2), 2);
        Point b = new Point(new Complex(0, 0), 0);

        assertEquals(3, a.distanceTo(b), DELTA);
    }

    @Test
    void distanceBetweenShiftedPoints() {
        Point a = new Point(new Complex(1, 1), 0);
        Point b = new Point(new Complex(0, 0), 1);

        assertEquals(Math.sqrt(3), a.distanceTo(b), DELTA);
    }

    @Test
    void distanceIsSymmetric() {
        Point a = new Point(new Complex(-2, 5), 1);
        Point b = new Point(new Complex(1, 1), -4);

        assertEquals(a.distanceTo(b), b.distanceTo(a), DELTA);
    }

    @Test
    void distanceToItselfIsZero() {
        Point point = new Point(new Complex(8, -3), 2.5);

        assertEquals(0, point.distanceTo(point), DELTA);
    }

    @Test
    void distanceFromOriginEqualsDistanceToOrigin() {
        Point point = new Point(new Complex(6, 8), 0);
        Point origin = new Point(0, 0, 0);

        assertEquals(10, point.distanceToOrigin(), DELTA);
        assertEquals(point.distanceToOrigin(), origin.distanceTo(point), DELTA);
    }

    @Test
    void storesComplexAndRealCoordinates() {
        Complex xy = new Complex(-1.5, 2.5);
        Point point = new Point(xy, 4);

        assertEquals(-1.5, point.getXy().getReal(), DELTA);
        assertEquals(2.5, point.getXy().getImaginary(), DELTA);
        assertEquals(4, point.getZ(), DELTA);
    }

    @Test
    void rejectsNullComplexCoordinate() {
        assertThrows(NullPointerException.class, () -> new Point(null, 1));
    }

    @Test
    void rejectsNullOtherPoint() {
        Point point = new Point(1, 1, 1);

        assertThrows(NullPointerException.class, () -> point.distanceTo(null));
    }
}
