package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.comparator.AmmunitionWeightComparator;
import org.example.entity.Ammunition;
import org.example.entity.Motorcyclist;

import java.util.ArrayList;
import java.util.List;

public class MotorcyclistService {

    private static final Logger LOGGER = LogManager.getLogger(MotorcyclistService.class);

    public double calculateTotalCost(Motorcyclist motorcyclist) {
        double total = motorcyclist.getAmmunition().stream()
                .mapToDouble(Ammunition::getPrice)
                .sum();
        LOGGER.info("Total ammunition cost for '{}': {}", motorcyclist.getName(), total);
        return total;
    }

    public List<Ammunition> sortByWeight(Motorcyclist motorcyclist) {
        List<Ammunition> sorted = new ArrayList<>(motorcyclist.getAmmunition());
        sorted.sort(new AmmunitionWeightComparator());
        LOGGER.info("Sorted {} item(s) by weight", sorted.size());
        return sorted;
    }

    public List<Ammunition> findByPriceRange(Motorcyclist motorcyclist, double minPrice, double maxPrice) {
        if (minPrice > maxPrice) {
            LOGGER.warn("Invalid price range [{}; {}], swapping bounds", minPrice, maxPrice);
            double temporary = minPrice;
            minPrice = maxPrice;
            maxPrice = temporary;
        }

        double finalMin = minPrice;
        double finalMax = maxPrice;
        List<Ammunition> found = motorcyclist.getAmmunition().stream()
                .filter(item -> item.getPrice() >= finalMin && item.getPrice() <= finalMax)
                .toList();

        LOGGER.info("Found {} item(s) in price range [{}; {}]", found.size(), finalMin, finalMax);
        return found;
    }
}
