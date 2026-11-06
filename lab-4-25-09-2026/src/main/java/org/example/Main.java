package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Ammunition;
import org.example.entity.Motorcyclist;
import org.example.factory.ConcreteAmmunitionFactory;
import org.example.factory.MotorcyclistCreator;
import org.example.service.MotorcyclistService;

import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Path dataFile = resolveDataFile(args);

        MotorcyclistCreator creator = new MotorcyclistCreator(new ConcreteAmmunitionFactory());
        Motorcyclist rider = creator.createEquipped("Alex Rider", dataFile);

        MotorcyclistService service = new MotorcyclistService();

        double totalCost = service.calculateTotalCost(rider);
        LOGGER.info("Equipped gear cost: {}", totalCost);

        List<Ammunition> byWeight = service.sortByWeight(rider);
        LOGGER.info("Ammunition sorted by weight:");
        byWeight.forEach(item -> LOGGER.info("  {}", item));

        double minPrice = 80.0;
        double maxPrice = 250.0;
        List<Ammunition> inRange = service.findByPriceRange(rider, minPrice, maxPrice);
        LOGGER.info("Ammunition in price range [{}; {}]:", minPrice, maxPrice);
        inRange.forEach(item -> LOGGER.info("  {}", item));
    }

    private static Path resolveDataFile(String[] args) {
        if (args.length > 0) {
            return Path.of(args[0]);
        }
        Path classpathFile = Path.of("src", "main", "resources", "ammunition.txt");
        if (classpathFile.toFile().exists()) {
            return classpathFile;
        }
        return Path.of("ammunition.txt");
    }
}
