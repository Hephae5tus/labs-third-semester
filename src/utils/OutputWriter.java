package utils;

import java.io.PrintStream;

public class OutputWriter {
    public static void printMatrix(int[][] matrix, PrintStream out) {
        for (int[] string : matrix) {
            for (int el : string) {
                out.print(el + " ");
            }
            out.println();
        }
    }
}
