package tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import utils.MyUtils;

/*
 7. Найти все p-значные числа из заданной последовательности натуральных чисел, в
записи которых встречаются не более k (k < p) различных цифр, и подсчитать их
количество.
*/

public class Task_7 {
    public static void run(Scanner in){
        var array = new ArrayList<Integer>(MyUtils.createList(in));

        System.out.print("""
                        Inputing p and k
                        Enter p:""");
        int p = in.nextInt();
        System.out.print("Enter k: ");
        int k = in.nextInt();
        var result = new ArrayList<Integer>(parse(array, p, k));
        System.out.println(result + " , " + result.size());
    }

    public static ArrayList<Integer> parse(ArrayList<Integer> array, int p, int k){
        if (!MyUtils.isArrayNatural(array)) throw new IllegalArgumentException("Array elements must be positive");
        if (k >= p) throw new IllegalArgumentException("k must be lower than p");

        ArrayList<Integer> result = new ArrayList<>();

        var filteredArray = new ArrayList<Integer>(MyUtils.filterByDigitsNumber(array, p));
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
