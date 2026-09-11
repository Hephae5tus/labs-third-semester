package tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task19Test {

    @Test
    @DisplayName("parse: подсчет седловых точек матрицы")
    void testParseSaddlePoints() {
        // Седловая точка — мин в строке и макс в столбце.
        // Матрица 3х3:
        // [1, 2] -> 1 (мин в строке 0, макс в столбце 0: 1 >= 0? Да)
        // [0, 0]
        int[][] matrix = {
                {3, 8},
                {1, 5}
        };
        // В {3, 8} мин=3 (столбец 0: 3 > 1 - макс!) -> (0,0) - седловая
        // В {1, 5} мин=1 (столбец 0: 1 < 3 - не макс)

        int result = Task19.parse(matrix, 2, 2);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("generateMatrix: генерация элементов в заданном диапазоне")
    void testGenerateMatrix() {
        int n = 4;
        int m = 4;
        int min = 10;
        int max = 50;
        int[][] matrix = new int[n][m];

        Task19.generateMatrix(matrix, n, m, min, max);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                assertTrue(matrix[i][j] >= min && matrix[i][j] < max,
                        "Элемент " + matrix[i][j] + " выходит за границы [" + min + ", " + max + ")");
            }
        }
    }

    @Test
    @DisplayName("run: интеграционный тест выполнения задачи Task19")
    void testRunIntegration() {
        // Ввод: n=2, m=2, min=1, max=10
        String simulatedInput = "2\n2\n1\n10\n";
        Scanner scanner = new Scanner(simulatedInput);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        Task19.run(scanner, out);

        String output = outStream.toString();
        assertTrue(output.contains("Number of saddle points"));
    }
}