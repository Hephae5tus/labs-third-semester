package utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputWriterTest {

    @Test
    void printsEachElementFollowedBySpaceAndEndsRowWithLineBreak() {
        String output = print(new int[][]{
                {1, 2},
                {3, 4}
        });

        String line = System.lineSeparator();
        assertEquals("1 2 " + line + "3 4 " + line, output);
    }

    @Test
    void printsNegativeNumbers() {
        String output = print(new int[][]{
                {-1, 0}
        });

        assertEquals("-1 0 " + System.lineSeparator(), output);
    }

    @Test
    void printsNothingForEmptyMatrix() {
        assertEquals("", print(new int[0][0]));
    }

    @Test
    void printsLineBreakForEmptyRow() {
        String output = print(new int[][]{
                {},
                {}
        });

        String line = System.lineSeparator();
        assertEquals(line + line, output);
    }

    private static String print(int[][] matrix) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer, true, StandardCharsets.UTF_8);
        OutputWriter.printMatrix(matrix, out);
        return buffer.toString(StandardCharsets.UTF_8);
    }
}
