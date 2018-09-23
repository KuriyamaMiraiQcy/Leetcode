import java.util.HashMap;
import java.util.List;

public class WorstStock {
    static int worstPerformingStock(List<List<Integer>> prices) {
        double minRate = Double.MAX_VALUE;
        int num = 0;

        for (List<Integer> str:prices) {
            int number = str.get(0);
            double openingPrice = str.get(1);
            double closingPrice = str.get(2);
            double returnRate =(closingPrice - openingPrice)/openingPrice;
            if (returnRate < minRate) {
                minRate = returnRate;
                num = number;
            }
        }
        return num;
    }
}
