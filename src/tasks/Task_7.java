package tasks;

import java.io.PrintStream;
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
    public static void run(Scanner in, PrintStream out){
        List<Integer> array = InputReader.createList(in, "Enter a number", "stop", out);
        int p = InputReader.readInt(in, "Enter p: ", out);
        int k = InputReader.readInt(in, "Enter k: ", out);
        List<Integer> result = parse(array, p, k);
        out.println(result + " , " + result.size());
    }

    public static List<Integer> parse(List<Integer> array, int p, int k){
        if (NumberValidator.isArrayNatural(array)) {
            throw new IllegalArgumentException("Array elements must be positive");
        }
        if (k < 1) {
            throw new IllegalArgumentException("k must be greater than 0");
        }
        if (k >= p) {
            throw new IllegalArgumentException("k must be lower than p");
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> filteredArray = DigitUtils.filterByDigitsNumber(array, p);
        Set<Integer> uniqueNums = new HashSet<>();

        for (int i : filteredArray) {
            for (int tempI = i; tempI != 0; tempI /= 10) {
                uniqueNums.add(tempI % 10);
            }
            if (uniqueNums.size() <= k) {
                result.add(i);
            }
            uniqueNums.clear();
        }
        return result;
    }
}
