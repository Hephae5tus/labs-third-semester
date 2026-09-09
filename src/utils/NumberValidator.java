package utils;

import java.util.List;

public class NumberValidator {
    public static boolean isArrayNatural(List<Integer> array){
        for (int i : array) {
            if (i <= 0) return false;
        }
        return true;
    }
}
