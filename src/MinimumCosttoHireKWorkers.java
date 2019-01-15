import java.util.Arrays;
import java.util.HashMap;

public class MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[] wagePerQuality = new double[quality.length];
        HashMap<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < quality.length; i++) {
            wagePerQuality[i] = (double) wage[i] / (double)quality[i];
            map.put(wagePerQuality[i], i);
        }

        Arrays.sort(wagePerQuality);

        double minimum = Double.MAX_VALUE;

        for (int i = K - 1; i < wagePerQuality.length; i++) {
            minimum = Math.min(minimum, getSumByChoosingK(map, wagePerQuality, quality, wage, i, K));
        }

        return minimum;
    }

    public double getSumByChoosingK(HashMap<Double, Integer> map, double[] percentage, int[] quality, int[] wage, int K, int num) {
        double maximumPercentage = percentage[K];

        double sum = wage[map.get(percentage[K])];
        int count = 0;

        int[] temp = quality.clone();
        Arrays.sort(temp);


        for (int i = percentage.length - 1; i >= 0; i++) {
            int index = map.get(percentage[i]);
            if (quality[index] * maximumPercentage > wage[index]) {
                count++;
                sum += quality[index] * maximumPercentage;
                if (count == num) {
                    break;
                }
            }
        }

        return sum;
    }
}
