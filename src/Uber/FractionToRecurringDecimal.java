import java.util.HashMap;
import java.util.HashSet;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long numer = (long) numerator;
        long denom = (long) denominator;
        StringBuilder res = new StringBuilder();
        if ((numer > 0 && denom < 0) || (numer < 0 && denom > 0)) {
            res.append("-");
        }
        numer = Math.abs(numer);
        denom = Math.abs(denom);
        if (numer % denom == 0) {
            res.append(numer / denom);
            return res.toString();
        }




        res.append(numer / denom);
        res.append(".");

        long remainder = numer % denom * 10;
        int nextIndex = res.length();
        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                res.append(")");
                int index = map.get(remainder);
                res.insert(index, "(");
                break;
            }
            long div = remainder / denom;
            res.append(div);
            map.put(remainder, nextIndex);
            remainder = remainder % denom * 10;
            nextIndex++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal a= new FractionToRecurringDecimal();
        System.out.print(a.fractionToDecimal(-2147483648, 1));
    }
}
