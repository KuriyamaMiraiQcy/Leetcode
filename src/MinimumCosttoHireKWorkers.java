import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int numWorkers = quality.length;

        /* qualityRatio[i] = {quality, wage[i] / quality[i]}. */
        double[][] qualityRatio = new double[numWorkers][2];

        for (int i = 0; i < numWorkers; i++) {
            qualityRatio[i][0] = quality[i];
            qualityRatio[i][1] = (double) wage[i] / quality[i];
        }

        Arrays.sort(qualityRatio, (a, b) -> Double.compare(a[1], b[1]));
        double minSumSalary = Integer.MAX_VALUE;
        int sumQuality = 0;;

        /* Always remove maximum quality. */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < numWorkers; i++) {
            maxHeap.add((int)qualityRatio[i][0]);
            sumQuality += qualityRatio[i][0];
            if (maxHeap.size() > K) {
                int qualityPolled = maxHeap.poll();
                sumQuality -= qualityPolled;
            }
            if (maxHeap.size() == K) {

                /* Calculate sumSalary. */
                double curRatio = qualityRatio[i][1];
                minSumSalary = Math.min(minSumSalary, sumQuality * curRatio);
            }
        }

        return minSumSalary;
    }
}
