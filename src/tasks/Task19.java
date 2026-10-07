package tasks;

import utils.InputReader;
import utils.OutputWriter;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

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
        int[] saddleCounts = IntStream.range(0, n)
                .map(row -> (int) IntStream.range(0, m)
                        .filter(column -> isSaddlePoint(matrix, row, column, n))
                        .count())
                .toArray();

        int[][] sortedRows = IntStream.range(0, n)
                .boxed()
                .sorted(Comparator.comparingInt((Integer row) -> saddleCounts[row]).reversed())
                .map(row -> matrix[row])
                .toArray(int[][]::new);
        System.arraycopy(sortedRows, 0, matrix, 0, n);

        return Arrays.stream(saddleCounts).sum();
    }

    public static void generateMatrix(int[][] matrix, int n, int m, int minValue, int maxValue) {
        Random random = new Random();
        IntStream.range(0, n).forEach(row ->
                IntStream.range(0, m).forEach(column ->
                        matrix[row][column] = random.nextInt(minValue, maxValue)));
    }

    private static boolean isSaddlePoint(int[][] matrix, int row, int column, int n) {
        return isMinInRow(matrix, row, column) && isMaxInColumn(matrix, row, column, n);
    }

    private static boolean isMinInRow(int[][] matrix, int row, int column) {
        int value = matrix[row][column];
        return Arrays.stream(matrix[row]).allMatch(element -> value <= element);
    }

    private static boolean isMaxInColumn(int[][] matrix, int row, int column, int n) {
        int value = matrix[row][column];
        return IntStream.range(0, n).allMatch(index -> value >= matrix[index][column]);
    }
}
