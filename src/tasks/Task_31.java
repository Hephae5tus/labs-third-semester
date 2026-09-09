package tasks;

import java.util.Scanner;

import utils.InputReader;
import utils.MathUtils;
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
    public static void run(Scanner in){

        List<Integer> array = InputReader.createList(in);
        System.out.println(parse(array));
    }

    public static List<Integer> parse(List<Integer> array) {
        if (!NumberValidator.isArrayNatural(array)) throw new IllegalArgumentException("Array elements must be positive");
        List<Integer> result = new ArrayList<Integer>();

        for (int i : array)
            if (MathUtils.isPerfect(i) && doesIncludeDigits(i))
                result.add(i);
        return result;
    }

    public static boolean doesIncludeDigits(int number) {
        for(int tempNum = number; tempNum != 0; tempNum/=10)
            if (tempNum%10 == 3 || tempNum%10 == 1)
                return true;
        return false;
    }
}
