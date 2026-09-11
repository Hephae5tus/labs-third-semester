package tasks;

import utils.InputReader;
import utils.OutputWriter;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
19. Найти количество всех седловых точек матрицы. (Матрица А имеет
седловую точку Аi,j, если Аi,j является минимальным элементом в i-й строке и
максимальным в j-м столбце). Отсортировать строки матрицы по количеству
седловых точек в строке.
 */

public class Task19 {
    public static void run(Scanner in, PrintStream out) {
        int n = InputReader.readInt(in, "Enter n: ", out);
        int m = InputReader.readInt(in, "Enter m: ", out);
        int minValue = InputReader.readInt(in, "Enter minValue: ", out);
        int maxValue = InputReader.readInt(in, "Enter maxValue: ", out);
        int[][] matrix = new int[n][m];
        generateMatrix(matrix, n, m, minValue, maxValue);
//        int[][] matrix = {
//                {4, 2, 2, 9},
//                {8, 5, 5, 6},
//                {1, 0, 0, 3}
//        };
        out.print("Original matrix:\n");
        OutputWriter.printMatrix(matrix, System.out);
        out.print("Parsed matrix:\n");
        int result = parse(matrix, n, m);
        out.print("\nNumber of saddle points = " + result + "\n");
        OutputWriter.printMatrix(matrix, System.out);
    }

    public static int parse(int[][] matrix, int n, int m) {
        int result = 0;
        Map<Integer, Integer> mapOfPoints = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isSaddlePoint(matrix, i, j, n, m)) {
                    result++;
                    mapOfPoints.put(i, (mapOfPoints.get(i) == null? 1 : mapOfPoints.get(i) + 1));
                }
            }
            mapOfPoints.putIfAbsent(i, 0);
        }

        for (int i = 1; i < n; i++) {
            if (mapOfPoints.get(i) > mapOfPoints.get(i - 1)) {
                swap(matrix, i, i - 1);
            }
        }
        return result;
    }

    public static void generateMatrix(int[][] matrix, int n, int m, int minValue, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(minValue, maxValue);
            }
        }
    }

    private static void swap(int[][] matrix, int string1, int string2) {
        int[] swap = matrix[string1];
        matrix[string1] = matrix[string2];
        matrix[string2] = swap;
    }

    private static boolean isSaddlePoint(int[][] matrix, int i, int j, int n, int m) {
        return isMinInString(matrix, i, j, m) && isMaxInColemn(matrix, i, j, n);
    }

    private static boolean isMinInString(int[][] matrix, int i, int j, int m) {
        for (int k = 0; k < m; k++) {
            if (matrix[i][j] > matrix[i][k]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMaxInColemn(int[][] matrix, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (matrix[i][j] < matrix[k][j]) {
                return false;
            }
        }
        return true;
    }
}
