package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    public static ArrayList<Integer> createList(Scanner in){
        System.out.println("Creating array");
        var result = new ArrayList<Integer>();
        while (true){
            System.out.print("Input a number(exit to stop): ");
            String line = in.nextLine();
            try {
                int number = Integer.parseInt(line);
                result.add(number);
            }
            catch (Throwable e) {
                if (line.equals("exit")) {
                    break;
                }
                System.out.println("Invalid value. Try again.");
            }
        }

        return result;
    }

    public static int readInt(Scanner in, String message) {
        int num;
        while (true){
            System.out.print(message);
            try{
                num = in.nextInt();
                return num;
            }
            catch (RuntimeException e) {
                System.out.println("Invalid value. Try again.");
            }
        }
    }
}
