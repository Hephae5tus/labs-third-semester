package org.example.comparator;

import org.example.entity.Gloves;
import org.example.entity.Helmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AmmunitionWeightComparatorTest {

    @Test
    void comparesByWeight() {
        AmmunitionWeightComparator comparator = new AmmunitionWeightComparator();
        Gloves light = new Gloves("G", 10, 0.2, "M", false);
        Helmet heavy = new Helmet("H", 100, 1.5, "L", true);

        assertTrue(comparator.compare(light, heavy) < 0);
        assertTrue(comparator.compare(heavy, light) > 0);
        assertTrue(comparator.compare(light, light) == 0);
    }
}
