package tasks;

import utils.DigitUtils;
import utils.InputReader;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.List;

/*
19. Найти и вывести все четырёхзначные числа из заданной последовательности
целых чисел. Подсчитать количество четырёхзначных чисел, сумма цифр которых равна
заданному числу k
*/

public class Task_19 {
    public static void run(Scanner in, PrintStream out){

        List<Integer> array = InputReader.createList(in, "Enter a number", "stop", out);
        int k = InputReader.readInt(in, "Input k: ",  out);
        List<Integer> filteredArray = DigitUtils.filterByDigitsNumber(array, 4);
        out.println(filteredArray + " , " + parse(filteredArray, k));
    }

    public static int parse(List<Integer> array, int k){
        int result = 0;
        for (int i : array) {
            int sum = 0;
            for (int tempI = Math.abs(i); tempI != 0; tempI/=10) {
                sum += tempI % 10;
            }
            if (sum == k) {
                result++;
            }
        }
        return result;
    }
}
