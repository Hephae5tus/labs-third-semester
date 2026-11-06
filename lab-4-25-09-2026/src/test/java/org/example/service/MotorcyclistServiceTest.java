package org.example.service;

import org.example.entity.Gloves;
import org.example.entity.Helmet;
import org.example.entity.Jacket;
import org.example.entity.Motorcyclist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MotorcyclistServiceTest {

    private MotorcyclistService service;
    private Motorcyclist rider;

    @BeforeEach
    void setUp() {
        service = new MotorcyclistService();
        rider = new Motorcyclist("Alex");
        rider.addAmmunition(new Jacket("J", 400, 3.0, "leather", 5));
        rider.addAmmunition(new Gloves("G", 90, 0.2, "M", true));
        rider.addAmmunition(new Helmet("H", 300, 1.2, "L", true));
    }

    @Test
    void calculatesTotalCost() {
        assertEquals(790.0, service.calculateTotalCost(rider), 0.001);
    }

    @Test
    void sortsByWeightAscending() {
        List<?> sorted = service.sortByWeight(rider);

        assertEquals("G", ((org.example.entity.Ammunition) sorted.get(0)).getName());
        assertEquals("H", ((org.example.entity.Ammunition) sorted.get(1)).getName());
        assertEquals("J", ((org.example.entity.Ammunition) sorted.get(2)).getName());
    }

    @Test
    void findsByPriceRange() {
        assertEquals(2, service.findByPriceRange(rider, 100, 400).size());
        assertEquals(1, service.findByPriceRange(rider, 80, 100).size());
    }

    @Test
    void swapsInvertedPriceRange() {
        assertEquals(2, service.findByPriceRange(rider, 400, 100).size());
    }
}
