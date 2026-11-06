package org.example.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Ammunition;
import org.example.factory.AmmunitionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AmmunitionFileReader {

    private static final Logger LOGGER = LogManager.getLogger(AmmunitionFileReader.class);

    private final AmmunitionFactory factory;

    public AmmunitionFileReader(AmmunitionFactory factory) {
        this.factory = factory;
    }

    public List<Ammunition> read(Path path) {
        List<Ammunition> result = new ArrayList<>();
        LOGGER.info("Reading ammunition from '{}'", path);

        List<String> lines;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            LOGGER.error("Cannot read file '{}': {}", path, exception.getMessage());
            return result;
        }

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            String[] parts = line.split(";", -1);
            if (parts.length < 1) {
                LOGGER.warn("Line {}: empty record ignored", i + 1);
                continue;
            }

            Ammunition ammunition = factory.create(parts[0], parts);
            if (ammunition == null) {
                LOGGER.warn("Line {}: record ignored", i + 1);
            } else {
                result.add(ammunition);
                LOGGER.trace("Line {}: loaded {}", i + 1, ammunition);
            }
        }

        LOGGER.info("Loaded {} ammunition item(s)", result.size());
        return result;
    }
}
