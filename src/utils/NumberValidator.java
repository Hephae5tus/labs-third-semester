package utils;

import java.util.List;

public final class NumberValidator {

    private NumberValidator() {
        throw new UnsupportedOperationException("Utility class cannot be created");
    }

    public static boolean isArrayNatural(List<Integer> array){
        for (int i : array) {
            if (i <= 0) {
                return false;
            }
        }
        return true;
    }
}
