package tasks;

import utils.InputReader;
import utils.OutputWriter;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int[][] columns = IntStream.range(0, m)
                .mapToObj(column -> IntStream.range(0, n)
                        .map(row -> matrix[row][column])
                        .toArray())
                .sorted(Comparator.comparingInt(Task7::countSameElements).reversed())
                .toArray(int[][]::new);

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                matrix[row][column] = columns[column][row];
            }
        }
    }

    private static int countSameElements(int[] column) {
        Map<Integer, Long> frequencies = Arrays.stream(column)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencies.values().stream()
                .mapToInt(Long::intValue)
                .max()
                .orElse(0);
    }
}
