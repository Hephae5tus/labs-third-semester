package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

import utils.DigitUtils;
import utils.InputReader;
import utils.NumberValidator;

/*
 7. Найти все p-значные числа из заданной последовательности натуральных чисел, в
записи которых встречаются не более k (k < p) различных цифр, и подсчитать их
количество.
*/

public class Task_7 {
    public static void run(Scanner in){
        List<Integer> array = InputReader.createList(in);
        int p = InputReader.readInt(in, "Enter p: ");
        int k = InputReader.readInt(in, "Enter k: ");
        List<Integer> result = parse(array, p, k);
        System.out.println(result + " , " + result.size());
    }

    public static List<Integer> parse(List<Integer> array, int p, int k){
        if (!NumberValidator.isArrayNatural(array))
            throw new IllegalArgumentException("Array elements must be positive");
        if (k >= p)
            throw new IllegalArgumentException("k must be lower than p");

        List<Integer> result = new ArrayList<>();

        List<Integer> filteredArray = DigitUtils.filterByDigitsNumber(array, p);
        for (int i : filteredArray) {
            int uniqueDigits = 0;
            for (int tempI = i; tempI != 0; tempI/=10) {
                int repeats = 0;
                int a = tempI % 10;
                for (int tempTempI = i; tempTempI != 0; tempTempI/=10)
                    if (a == (tempTempI % 10)) repeats++;
                if (repeats == 1) uniqueDigits++;
            }
            if (uniqueDigits <= k) result.add(i);
        }
        return result;
    }
}
