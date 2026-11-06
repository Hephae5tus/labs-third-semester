package org.example.factory;

import org.example.entity.Motorcyclist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MotorcyclistCreatorTest {

    @TempDir
    Path tempDir;

    @Test
    void createsEquippedMotorcyclistFromFile() throws IOException {
        Path file = tempDir.resolve("gear.txt");
        Files.writeString(file, """
                HELMET;Shoei;300;1.2;L;true
                GLOVES;Dainese;90;0.2;M;true
                """);

        MotorcyclistCreator creator = new MotorcyclistCreator(new ConcreteAmmunitionFactory());
        Motorcyclist rider = creator.createEquipped("Alex", file);

        assertEquals("Alex", rider.getName());
        assertEquals(2, rider.getAmmunition().size());
        assertFalse(rider.getAmmunition().isEmpty());
    }
}
