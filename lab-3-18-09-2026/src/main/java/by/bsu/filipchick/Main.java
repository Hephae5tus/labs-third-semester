package by.bsu.filipchick;

import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    static void main() {
        Point a = new Point(new Complex(3, 4), 12);
        Point b = new Point(new Complex(0, 0), 0);

        log.info("Точка A: " + a);
        log.info("Точка B: " + b);
        log.info("Расстояние A до начала координат: " + a.distanceToOrigin());
        log.info("Расстояние между A и B: " + a.distanceTo(b));
    }
}
