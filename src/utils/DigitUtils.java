package utils;

import java.util.List;
import java.util.ArrayList;

public final class DigitUtils {

    private DigitUtils() {
        throw new UnsupportedOperationException("Utility class cannot be created");
    }

    public static List<Integer> filterByDigitsNumber(List<Integer> array, int p){
        List<Integer> result = new ArrayList<>();
        for (int i : array) {
            int length = 0;
            int tempI = i;
            do {
                length++;
                tempI /= 10;
            } while (tempI != 0);
            if (length == p) result.add(i);
        }
        return result;
    }
}
