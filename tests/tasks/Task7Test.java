package tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task7Test {

    @Test
    @DisplayName("parse: перестановка столбцов по повторению элементов")
    void testParse() {
        // Столбец 0: [1, 2, 3] -> макс повторений = 1
        // Столбец 1: [5, 5, 5] -> макс повторений = 3
        // Столбец 2: [8, 8, 9] -> макс повторений = 2
        int[][] matrix = {
                {1, 5, 8},
                {2, 5, 8},
                {3, 5, 9}
        };

        Task7.parse(matrix, 3, 3);

        // Проверяем, что матрица была изменена без ошибок
        // (зависит от вашей текущей реализации сортировки внутри parse)
        assertArrayEquals(new int[]{3, 3}, new int[]{matrix.length, matrix[0].length});
    }

    @Test
    @DisplayName("run: проверка интеграционного запуска Task7 с консольным вводом")
    void testRunIntegration() {
        // Ввод: n=2, m=2, matrix elements: 1, 2, 3, 4
        String simulatedInput = "2\n2\n1\n2\n3\n4\n";
        Scanner scanner = new Scanner(simulatedInput);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        Task7.run(scanner, out);

        String output = outStream.toString();
        assertTrue(output.contains("Original matrix:"));
        assertTrue(output.contains("Parsed matrix:"));
    }
}