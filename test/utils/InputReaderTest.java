package utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderTest {

    @Test
    void readsIntegerAndPrintsPrompt() {
        Recording recording = new Recording("42");

        int value = InputReader.readInt(recording.scanner, "Enter n: ", recording.out);

        assertEquals(42, value);
        assertEquals("Enter n: ", recording.text());
    }

    @Test
    void asksAgainWhenIntegerIsInvalid() {
        Recording recording = new Recording("abc\n-7");

        int value = InputReader.readInt(recording.scanner, "Enter n: ", recording.out);

        assertEquals(-7, value);
        String line = System.lineSeparator();
        assertEquals("Enter n: Invalid value. Try again." + line + "Enter n: ", recording.text());
    }

    @Test
    void readsMatrixByRowsAndSkipsInvalidNumbers() {
        Recording recording = new Recording("1\nx\n2\n3\n4");
        int[][] matrix = new int[2][2];

        InputReader.readArray(recording.scanner, "Enter number: ", matrix, 2, 2, recording.out);

        assertArrayEquals(new int[][]{
                {1, 2},
                {3, 4}
        }, matrix);
        String line = System.lineSeparator();
        String prompt = "Enter number: ";
        assertEquals(
                prompt + prompt + "Invalid value. Try again." + line + prompt + prompt + prompt,
                recording.text()
        );
    }

    private static final class Recording implements AutoCloseable {
        private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        private final Scanner scanner;
        private final PrintStream out;

        private Recording(String input) {
            scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            out = new PrintStream(buffer, true, StandardCharsets.UTF_8);
        }

        private String text() {
            return buffer.toString(StandardCharsets.UTF_8);
        }

        @Override
        public void close() {
            scanner.close();
            out.close();
        }
    }
}
