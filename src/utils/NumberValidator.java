package utils;

import java.util.ArrayList;

public class NumberValidator {
    public static boolean isArrayNatural(ArrayList<Integer> array){
        for (int i : array) {
            if (i <= 0) return false;
        }
        return true;
    }
}
