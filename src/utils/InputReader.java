package utils;

import java.io.PrintStream;
import java.util.Scanner;

public class InputReader {
    public static void readArray(Scanner in, String message, int[][] array, int n, int m, PrintStream out) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                while (true) {
                    out.print(message);
                    String line = in.nextLine();
                    try {
                        int number = Integer.parseInt(line);
                        array[i][j] = number;
                        break;
                    }
                    catch (NumberFormatException e) {
                        out.println("Invalid value. Try again.");
                    }
                }
            }
        }
    }

    public static int readInt(Scanner in, String message, PrintStream out) {
        while (true) {
            out.print(message);
            String line = in.nextLine();
            try {
                return Integer.parseInt(line);
            }
            catch (NumberFormatException e) {
                out.println("Invalid value. Try again.");
            }
        }
    }
}
