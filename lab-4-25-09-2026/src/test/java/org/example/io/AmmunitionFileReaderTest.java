package org.example.io;

import org.example.entity.Ammunition;
import org.example.factory.ConcreteAmmunitionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AmmunitionFileReaderTest {

    @TempDir
    Path tempDir;

    @Test
    void readsValidLinesAndSkipsComments() throws IOException {
        Path file = tempDir.resolve("data.txt");
        Files.writeString(file, """
                # comment
                HELMET;Shoei;300;1.2;L;true
                UNKNOWN;x;1;1
                JACKET;Astar;400;3;leather;5
                """);

        AmmunitionFileReader reader = new AmmunitionFileReader(new ConcreteAmmunitionFactory());
        List<Ammunition> items = reader.read(file);

        assertEquals(2, items.size());
        assertEquals("HELMET", items.get(0).getType());
        assertEquals("JACKET", items.get(1).getType());
    }

    @Test
    void returnsEmptyListWhenFileMissing() {
        AmmunitionFileReader reader = new AmmunitionFileReader(new ConcreteAmmunitionFactory());
        List<Ammunition> items = reader.read(tempDir.resolve("missing.txt"));

        assertTrue(items.isEmpty());
    }
}
