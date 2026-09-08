package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyUtils {
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

    public static boolean isArrayNatural(ArrayList<Integer> array){
        for (int i : array) {
            if (i <= 0) return false;
        }
        return true;
    }

    public static ArrayList<Integer> filterByDigitsNumber(ArrayList<Integer> array, int p){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : array) {
            String newI = String.valueOf(i);
            if (newI.length() == p) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum+=i;
        }
        return number == sum;
    }
}
