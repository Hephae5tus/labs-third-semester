package tasks;

import java.util.Scanner;
import utils.MyUtils;
import java.util.ArrayList;

/*
31. Найти и вывести из заданной последовательности натуральных чисел, все
совершенные числа в записи которых есть цифры 3 или 1. Совершенным называется
число, равное сумме всех своих делителей, не равных самому числу, например, 6 = 1 + 2
+ 3 или 28 = 1 + 2 + 4 + 7 + 14.
*/

public class Task_31 {
    public static void run(Scanner in){

        var array = new ArrayList<Integer>(MyUtils.createList(in));
        System.out.println(parse(array));
    }

    public static ArrayList<Integer> parse(ArrayList<Integer> array) {
        if (!MyUtils.isArrayNatural(array)) throw new IllegalArgumentException("Array elements must be positive");
        var result = new ArrayList<Integer>();

        for (int i : array) {
            if (MyUtils.isPerfect(i) && doesIncludeDigits(i)) {
                result.add(i);
            }
        }if (!MyUtils.isArrayNatural(array)) throw new IllegalArgumentException("Array elements must be positive");

        return result;
    }

    public static boolean doesIncludeDigits(int number) {
        char[] newNum = String.valueOf(number).toCharArray();

        for(char i : newNum){
            if (i == '3' || i == '1') return true;
        }
        return false;
    }

}
