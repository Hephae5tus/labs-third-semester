package org.example.factory;

import org.example.entity.Ammunition;
import org.example.entity.Boots;
import org.example.entity.Gloves;
import org.example.entity.Helmet;
import org.example.entity.Jacket;
import org.example.entity.Pants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConcreteAmmunitionFactoryTest {

    private ConcreteAmmunitionFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ConcreteAmmunitionFactory();
    }

    @Test
    void createsAllKnownTypes() {
        assertInstanceOf(Helmet.class, factory.create("HELMET",
                "HELMET;H;100;1.2;L;true".split(";")));
        assertInstanceOf(Jacket.class, factory.create("JACKET",
                "JACKET;J;200;3;leather;5".split(";")));
        assertInstanceOf(Gloves.class, factory.create("GLOVES",
                "GLOVES;G;50;0.2;M;false".split(";")));
        assertInstanceOf(Boots.class, factory.create("BOOTS",
                "BOOTS;B;150;2;42;25".split(";")));
        assertInstanceOf(Pants.class, factory.create("PANTS",
                "PANTS;P;120;1.5;textile;true".split(";")));
    }

    @Test
    void ignoresUnknownAndEmptyType() {
        assertNull(factory.create("UNKNOWN", "UNKNOWN;x;1;1".split(";")));
        assertNull(factory.create(" ", new String[]{" "}));
        assertNull(factory.create(null, new String[]{}));
    }

    @Test
    void appliesDefaultsForInvalidFields() {
        Ammunition helmet = factory.create("HELMET", "HELMET;;-5;bad;;".split(";"));

        assertEquals("Unknown", helmet.getName());
        assertEquals(0.0, helmet.getPrice());
        assertEquals(0.1, helmet.getWeight());
        assertEquals("M", ((Helmet) helmet).getSize());
        assertTrue(((Helmet) helmet).isHasVisor());
    }

    @Test
    void bootsUseDefaultSizeWhenInvalid() {
        Boots boots = (Boots) factory.create("BOOTS", "BOOTS;B;10;1;xx;yy".split(";"));

        assertEquals(42, boots.getSize());
        assertEquals(20.0, boots.getShaftHeight());
    }
}
