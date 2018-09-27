import java.util.HashMap;
import java.util.HashSet;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return Integer.toString(numerator / denominator);
        }

        StringBuilder res = new StringBuilder();
        res.append(numerator / denominator);
        res.append(".");
        int remainder = numerator % denominator * 10;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (remainder != 0) {

        }


    }
}
