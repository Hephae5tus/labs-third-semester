package org.example.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Ammunition;
import org.example.entity.Motorcyclist;
import org.example.io.AmmunitionFileReader;

import java.nio.file.Path;
import java.util.List;

public class MotorcyclistCreator {

    private static final Logger LOGGER = LogManager.getLogger(MotorcyclistCreator.class);

    private final AmmunitionFileReader fileReader;

    public MotorcyclistCreator(AmmunitionFactory factory) {
        this.fileReader = new AmmunitionFileReader(factory);
    }

    public MotorcyclistCreator(AmmunitionFileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Motorcyclist createEquipped(String riderName, Path dataFile) {
        LOGGER.info("Creating motorcyclist '{}'", riderName);
        Motorcyclist motorcyclist = new Motorcyclist(riderName);
        List<Ammunition> items = fileReader.read(dataFile);
        for (Ammunition item : items) {
            motorcyclist.addAmmunition(item);
        }
        LOGGER.info("Motorcyclist '{}' equipped with {} item(s)", riderName, items.size());
        return motorcyclist;
    }
}
