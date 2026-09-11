package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputWriterTest {

    @Test
    @DisplayName("printMatrix: проверка правильности вывода двумерного массива")
    void testPrintMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        OutputWriter.printMatrix(matrix, out);

        String expected = "1 2 3 \n4 5 6 \n";
        // Приводим переносы строк к \n для универсальности между OS
        assertEquals(expected, outStream.toString().replace("\r\n", "\n"));
    }
}