package tasks;

import utils.MyUtils;
import java.util.Scanner;
import java.util.ArrayList;

/*
19. Найти и вывести все четырёхзначные числа из заданной последовательности
целых чисел. Подсчитать количество четырёхзначных чисел, сумма цифр которых равна
заданному числу k
*/

public class Task_19 {
    public static void run(Scanner in){

        var array = new ArrayList<Integer>(MyUtils.createList(in));
        System.out.print("""
                        Inputing k
                        Input k:""");
        int k = in.nextInt();
        var filteredArray = new ArrayList<Integer>(MyUtils.filterByDigitsNumber(array, 4));
        System.out.println(filteredArray + " , " + parse(array, k));

    }

    public static int parse(ArrayList<Integer> array, int k){
        int result = 0;

        for (int i : array) {
            String newI = String.valueOf(i);
            int temp = 0;
            for (char n : newI.toCharArray()) {
                temp += Character.getNumericValue(n);
            }
            if (temp == k) result++;
        }

        return result;
    }
}
