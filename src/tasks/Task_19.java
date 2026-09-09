package tasks;

import utils.DigitUtils;
import utils.InputReader;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*
19. Найти и вывести все четырёхзначные числа из заданной последовательности
целых чисел. Подсчитать количество четырёхзначных чисел, сумма цифр которых равна
заданному числу k
*/

public class Task_19 {
    public static void run(Scanner in){

        List<Integer> array = InputReader.createList(in);
        int k = InputReader.readInt(in, "Input k: ");
        List<Integer> filteredArray = DigitUtils.filterByDigitsNumber(array, 4);
        System.out.println(filteredArray + " , " + parse(filteredArray, k));
    }

    public static int parse(List<Integer> array, int k){
        int result = 0;

        for (int i : array) {
            int sum = 0;
            for (int tempI = i; tempI != 0; tempI/=10)
                sum += tempI%10;
            if (sum == k) result++;
        }
        return result;
    }
}
