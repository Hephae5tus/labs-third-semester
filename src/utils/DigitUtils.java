package utils;

import java.util.ArrayList;

public class DigitUtils {
    public static ArrayList<Integer> filterByDigitsNumber(ArrayList<Integer> array, int p){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : array) {
            String newI = String.valueOf(i);
            if (newI.length() == p) {
                result.add(i);
            }
        }

        return result;
    }
}
