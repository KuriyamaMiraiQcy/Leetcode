import java.util.Collections;
import java.util.List;

public class FindOptimalWeights {
    Pair findOptimalWeights(int numPallets, double maxCapacity, List<Double> wtPallets) {
        Collections.sort(wtPallets);
        int low = 0, high = wtPallets.size() - 1;
        Double diff = Double.MAX_VALUE;
        int first = 0;
        int second = high;

        while (low < high) {
            double sum = wtPallets.get(low) + wtPallets.get(high);

            if (sum >= maxCapacity) {
                high--;
                continue;
            } else {
                low++;
            }

            if (maxCapacity - sum < diff) {
                diff = maxCapacity - sum;
                first = low;
                second = high;
            }
        }

        return new Pair(wtPallets.get(first), wtPallets.get(second));
    }
}
