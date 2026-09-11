package tasks;

import utils.InputReader;
import utils.OutputWriter;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
7. Дана целочисленная матрица размера A(n,m). Отсортировать
столбцы матрицы по количеству одинаковых элементов в столбце.
 */

public class Task7 {
    public static void run(Scanner in, PrintStream out) {
        int n = InputReader.readInt(in, "Enter n: ", System.out);
        int m = InputReader.readInt(in, "Enter m: ", System.out);
        int[][] matrix = new int[n][m];
        InputReader.readArray(in, "Enter number: ", matrix, n, m, System.out);
        out.print("Original matrix:\n");
        OutputWriter.printMatrix(matrix, System.out);
        out.print("Parsed matrix:\n");
        parse(matrix, n, m);
        OutputWriter.printMatrix(matrix, System.out);
    }

    public static void parse(int[][] matrix, int n, int m) {
        Map<Integer, Integer> mapOfReps = new HashMap<>();
        for (int t = 0; t < m - 1; t++) {
            int prevNumOfReps = 0;
            for (int i = 0; i < m; i++) {
                int numOfReps = 0;

                for (int j = 0; j < n; j++) {
                    mapOfReps.put(matrix[j][i], (mapOfReps.get(matrix[j][i]) == null? 1 : mapOfReps.get(matrix[j][i]) + 1));
                }

                for (int key : mapOfReps.keySet()) {
                    if (numOfReps < mapOfReps.get(key)) {
                        numOfReps = mapOfReps.get(key);
                    }
                }

                mapOfReps.clear();

                if (prevNumOfReps < numOfReps && i != 0) {
                    swapColumns(matrix, n, i - 1, i);
                    continue;
                }

                prevNumOfReps = numOfReps;
            }
        }
    }

    private static void swapColumns(int[][] matrix, int n, int col1, int col2) {
        for (int i = 0; i < n; i++) {
            int swap = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = swap;
        }
    }
}
