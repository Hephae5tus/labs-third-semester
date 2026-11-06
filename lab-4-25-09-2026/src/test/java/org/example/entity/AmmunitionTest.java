package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AmmunitionTest {

    @Test
    void helmetStoresExtraProperties() {
        Helmet helmet = new Helmet("Shoei", 300, 1.2, "L", true);

        assertEquals("HELMET", helmet.getType());
        assertEquals("L", helmet.getSize());
        assertTrue(helmet.isHasVisor());
        helmet.setHasVisor(false);
        assertFalse(helmet.isHasVisor());
    }

    @Test
    void jacketStoresExtraProperties() {
        Jacket jacket = new Jacket("Astar", 400, 3.0, "leather", 4);

        assertEquals("JACKET", jacket.getType());
        assertEquals("leather", jacket.getMaterial());
        assertEquals(4, jacket.getProtectionLevel());
        jacket.setProtectionLevel(5);
        assertEquals(5, jacket.getProtectionLevel());
    }

    @Test
    void glovesBootsPantsCreateCorrectly() {
        Gloves gloves = new Gloves("Dainese", 90, 0.2, "M", true);
        Boots boots = new Boots("TCX", 200, 2.0, 43, 28);
        Pants pants = new Pants("RevIt", 170, 1.5, "textile", true);

        assertEquals("GLOVES", gloves.getType());
        assertTrue(gloves.isWaterproof());
        assertEquals("BOOTS", boots.getType());
        assertEquals(43, boots.getSize());
        assertEquals("PANTS", pants.getType());
        assertTrue(pants.isHasKneePads());
    }

    @Test
    void equalsAndHashCodeDependOnFields() {
        Helmet first = new Helmet("Shoei", 300, 1.2, "L", true);
        Helmet second = new Helmet("Shoei", 300, 1.2, "L", true);
        Helmet third = new Helmet("Arai", 300, 1.2, "L", true);

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
        assertNotEquals(first, third);
    }

    @Test
    void motorcyclistHoldsAmmunition() {
        Motorcyclist rider = new Motorcyclist("Alex");
        rider.addAmmunition(new Helmet("H", 100, 1, "M", true));
        rider.addAmmunition(null);

        assertEquals(1, rider.getAmmunition().size());
        assertEquals("Alex", rider.getName());
        rider.clearAmmunition();
        assertTrue(rider.getAmmunition().isEmpty());
    }
}
