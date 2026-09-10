package utils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class InputReader {

    private InputReader() {
        throw new UnsupportedOperationException("Utility class cannot be created");
    }

    public static List<Integer> createList(Scanner in, String message, String stopWord, PrintStream out){
        List<Integer> result = new ArrayList<>();
        while (true) {
            out.print(message + " (Enter " + stopWord + " to break): ");
            String line = in.nextLine();
            try {
                int number = Integer.parseInt(line);
                result.add(number);
            }
            catch (NumberFormatException e) {
                if (line.equals(stopWord)) {
                    break;
                }
                out.println("Invalid value. Try again.");
            }
        }
        return result;
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
