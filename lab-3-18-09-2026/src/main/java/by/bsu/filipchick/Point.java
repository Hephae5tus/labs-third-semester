package by.bsu.filipchick;

import java.util.Objects;

public final class Point {
    private final Complex xy;
    private final double z;

    public Point(Complex xy, double z) {
        this.xy = Objects.requireNonNull(xy, "xy");
        this.z = z;
    }

    public Point(double x, double y, double z) {
        this(new Complex(x, y), z);
    }

    public Complex getXy() {
        return xy;
    }

    public double getZ() {
        return z;
    }

    public double distanceTo(Point other) {
        Objects.requireNonNull(other, "other");
        double planar = xy.subtract(other.xy).modulus();
        return Math.hypot(planar, z - other.z);
    }

    public double distanceToOrigin() {
        return Math.hypot(xy.modulus(), z);
    }

    @Override
    public String toString() {
        return "Point(" + xy + ", z=" + z + ")";
    }
}
