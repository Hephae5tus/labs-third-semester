package org.example.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Ammunition;
import org.example.entity.Boots;
import org.example.entity.Gloves;
import org.example.entity.Helmet;
import org.example.entity.Jacket;
import org.example.entity.Pants;

public class ConcreteAmmunitionFactory implements AmmunitionFactory {

    private static final Logger LOGGER = LogManager.getLogger(ConcreteAmmunitionFactory.class);

    private static final String DEFAULT_NAME = "Unknown";
    private static final double DEFAULT_PRICE = 0.0;
    private static final double DEFAULT_WEIGHT = 0.1;
    private static final String DEFAULT_SIZE = "M";
    private static final String DEFAULT_MATERIAL = "textile";
    private static final int DEFAULT_PROTECTION = 1;
    private static final int DEFAULT_BOOT_SIZE = 42;
    private static final double DEFAULT_SHAFT = 20.0;

    @Override
    public Ammunition create(String type, String[] parts) {
        if (type == null || type.isBlank()) {
            LOGGER.warn("Empty ammunition type, record ignored");
            return null;
        }

        String normalized = type.trim().toUpperCase();
        try {
            return switch (normalized) {
                case "HELMET" -> createHelmet(parts);
                case "JACKET" -> createJacket(parts);
                case "GLOVES" -> createGloves(parts);
                case "BOOTS" -> createBoots(parts);
                case "PANTS" -> createPants(parts);
                default -> {
                    LOGGER.warn("Unknown ammunition type '{}', record ignored", type);
                    yield null;
                }
            };
        } catch (RuntimeException exception) {
            LOGGER.error("Failed to create ammunition of type '{}': {}", type, exception.getMessage());
            return null;
        }
    }

    private Helmet createHelmet(String[] parts) {
        String name = parseName(parts, 1);
        double price = parsePositiveDouble(parts, 2, DEFAULT_PRICE, "helmet price");
        double weight = parsePositiveDouble(parts, 3, DEFAULT_WEIGHT, "helmet weight");
        String size = parseNonBlank(parts, 4, DEFAULT_SIZE, "helmet size");
        boolean hasVisor = parseBoolean(parts, 5, true);
        LOGGER.debug("Created helmet '{}'", name);
        return new Helmet(name, price, weight, size, hasVisor);
    }

    private Jacket createJacket(String[] parts) {
        String name = parseName(parts, 1);
        double price = parsePositiveDouble(parts, 2, DEFAULT_PRICE, "jacket price");
        double weight = parsePositiveDouble(parts, 3, DEFAULT_WEIGHT, "jacket weight");
        String material = parseNonBlank(parts, 4, DEFAULT_MATERIAL, "jacket material");
        int protection = parsePositiveInt(parts, 5, DEFAULT_PROTECTION, "jacket protection");
        LOGGER.debug("Created jacket '{}'", name);
        return new Jacket(name, price, weight, material, protection);
    }

    private Gloves createGloves(String[] parts) {
        String name = parseName(parts, 1);
        double price = parsePositiveDouble(parts, 2, DEFAULT_PRICE, "gloves price");
        double weight = parsePositiveDouble(parts, 3, DEFAULT_WEIGHT, "gloves weight");
        String size = parseNonBlank(parts, 4, DEFAULT_SIZE, "gloves size");
        boolean waterproof = parseBoolean(parts, 5, false);
        LOGGER.debug("Created gloves '{}'", name);
        return new Gloves(name, price, weight, size, waterproof);
    }

    private Boots createBoots(String[] parts) {
        String name = parseName(parts, 1);
        double price = parsePositiveDouble(parts, 2, DEFAULT_PRICE, "boots price");
        double weight = parsePositiveDouble(parts, 3, DEFAULT_WEIGHT, "boots weight");
        int size = parsePositiveInt(parts, 4, DEFAULT_BOOT_SIZE, "boots size");
        double shaftHeight = parsePositiveDouble(parts, 5, DEFAULT_SHAFT, "boots shaft");
        LOGGER.debug("Created boots '{}'", name);
        return new Boots(name, price, weight, size, shaftHeight);
    }

    private Pants createPants(String[] parts) {
        String name = parseName(parts, 1);
        double price = parsePositiveDouble(parts, 2, DEFAULT_PRICE, "pants price");
        double weight = parsePositiveDouble(parts, 3, DEFAULT_WEIGHT, "pants weight");
        String material = parseNonBlank(parts, 4, DEFAULT_MATERIAL, "pants material");
        boolean hasKneePads = parseBoolean(parts, 5, true);
        LOGGER.debug("Created pants '{}'", name);
        return new Pants(name, price, weight, material, hasKneePads);
    }

    private String parseName(String[] parts, int index) {
        return parseNonBlank(parts, index, DEFAULT_NAME, "name");
    }

    private String parseNonBlank(String[] parts, int index, String defaultValue, String field) {
        if (parts.length <= index || parts[index] == null || parts[index].isBlank()) {
            LOGGER.warn("Invalid {}, using default '{}'", field, defaultValue);
            return defaultValue;
        }
        return parts[index].trim();
    }

    private double parsePositiveDouble(String[] parts, int index, double defaultValue, String field) {
        if (parts.length <= index) {
            LOGGER.warn("Missing {}, using default {}", field, defaultValue);
            return defaultValue;
        }
        try {
            double value = Double.parseDouble(parts[index].trim());
            if (value < 0) {
                LOGGER.warn("Negative {}, using default {}", field, defaultValue);
                return defaultValue;
            }
            return value;
        } catch (NumberFormatException exception) {
            LOGGER.warn("Non-numeric {}, using default {}", field, defaultValue);
            return defaultValue;
        }
    }

    private int parsePositiveInt(String[] parts, int index, int defaultValue, String field) {
        if (parts.length <= index) {
            LOGGER.warn("Missing {}, using default {}", field, defaultValue);
            return defaultValue;
        }
        try {
            int value = Integer.parseInt(parts[index].trim());
            if (value <= 0) {
                LOGGER.warn("Non-positive {}, using default {}", field, defaultValue);
                return defaultValue;
            }
            return value;
        } catch (NumberFormatException exception) {
            LOGGER.warn("Non-numeric {}, using default {}", field, defaultValue);
            return defaultValue;
        }
    }

    private boolean parseBoolean(String[] parts, int index, boolean defaultValue) {
        if (parts.length <= index || parts[index] == null || parts[index].isBlank()) {
            return defaultValue;
        }
        return Boolean.parseBoolean(parts[index].trim());
    }
}
