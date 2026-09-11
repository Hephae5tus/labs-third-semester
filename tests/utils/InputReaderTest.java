package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderTest {

    @Test
    @DisplayName("readInt: корректный ввод числа с первой попытки")
    void testReadIntValid() {
        String input = "42\n";
        Scanner scanner = new Scanner(input);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        int result = InputReader.readInt(scanner, "Enter number: ", out);

        assertEquals(42, result);
        assertEquals("Enter number: ", outStream.toString());
    }

    @Test
    @DisplayName("readInt: сперва некорректная строка, затем валидное число")
    void testReadIntWithInvalidInputFirst() {
        String input = "abc\n10\n";
        Scanner scanner = new Scanner(input);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        int result = InputReader.readInt(scanner, "Enter: ", out);

        assertEquals(10, result);
        String output = outStream.toString();
        // Должен вывести подсказку, сообщение об ошибке и повторную подсказку
        assertEquals("Enter: Invalid value. Try again.\nEnter: ", output.replace("\r\n", "\n"));
    }

    @Test
    @DisplayName("readArray: считывание матрицы 2x2 с обработкой плохих значений")
    void testReadArray() {
        // Первые три корректны, далее одна ошибка, за которой следует верное число
        String input = "1\n2\n3\nwrong\n4\n";
        Scanner scanner = new Scanner(input);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        int[][] matrix = new int[2][2];
        InputReader.readArray(scanner, "> ", matrix, 2, 2, out);

        int[][] expected = {
                {1, 2},
                {3, 4}
        };

        assertArrayEquals(expected, matrix);
    }
}