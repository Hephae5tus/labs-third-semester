package utils;

import java.util.List;
import java.util.ArrayList;

public class DigitUtils {
    public static List<Integer> filterByDigitsNumber(List<Integer> array, int p){
        List<Integer> result = new ArrayList<>();

        for (int i : array) {
            int length = 0;
            double tempI = i;
            while (Math.abs(tempI) >= 1) {
                length++;
                tempI /= 10.0;
            }
            if (length == p) {
                result.add(i);
            }
        }
        return result;
    }
}
