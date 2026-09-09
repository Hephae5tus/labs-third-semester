package tasks;

import java.util.ArrayList;
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
        var result = new ArrayList<Integer>(parse(array, p, k));
        System.out.println(result + " , " + result.size());
    }

    public static ArrayList<Integer> parse(List<Integer> array, int p, int k){
        if (!NumberValidator.isArrayNatural(array)) throw new IllegalArgumentException("Array elements must be positive");
        if (k >= p) throw new IllegalArgumentException("k must be lower than p");

        ArrayList<Integer> result = new ArrayList<>();

        var filteredArray = new ArrayList<Integer>(DigitUtils.filterByDigitsNumber(array, p));
        for (int i : filteredArray) {
            String newI = String.valueOf(i);

            Set<Character> uniqueNumbers = new HashSet<>();
            for (char n : newI.toCharArray()) {
                uniqueNumbers.add(n);
            }

            if (uniqueNumbers.size() <= k) {
                result.add(i);
            }
        }

        return result;
    }
}
