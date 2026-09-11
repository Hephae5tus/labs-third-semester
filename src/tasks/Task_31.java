package tasks;

import java.io.PrintStream;
import java.util.Scanner;

import utils.InputReader;
import utils.NumberValidator;

import java.util.ArrayList;
import java.util.List;

/*
31. Найти и вывести из заданной последовательности натуральных чисел, все
совершенные числа в записи которых есть цифры 3 или 1. Совершенным называется
число, равное сумме всех своих делителей, не равных самому числу, например, 6 = 1 + 2
+ 3 или 28 = 1 + 2 + 4 + 7 + 14.
*/

public class Task_31 {
    public static void run(Scanner in, PrintStream out){
        List<Integer> array = InputReader.createList(in, "Enter a number", "stop", out);
        out.println(parse(array));
    }

    public static List<Integer> parse(List<Integer> array) {
        if (!NumberValidator.isArrayNatural(array)) {
            throw new IllegalArgumentException("Array elements must be positive");
        }

        List<Integer> result = new ArrayList<>();
        for (int i : array) {
            if (isPerfect(i) && doesIncludeDigits(i)) {
                boolean add = result.add(i);
            }
        }
        return result;
    }

    private static boolean doesIncludeDigits(int number) {
        for(int tempNum = number; tempNum != 0; tempNum /= 10) {
            if (tempNum % 10 == 3 || tempNum % 10 == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return number == sum;
    }
}
