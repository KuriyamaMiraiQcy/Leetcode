import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {
    TreeSet<Integer> minSet;
    TreeSet<Integer> maxSet;

    private void addNumber(int num) {
        maxSet.add(num);
        minSet.add(maxSet.pollFirst());

        if (maxSet.size() < minSet.size()) {
            maxSet.add(minSet.pollFirst());
        }
    }

    private void removeNumber(int num) {
        if (minSet.contains(num)) {
            minSet.remove(num);
        } else {
            maxSet.remove(num);
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        minSet = new TreeSet<>(comparator);
        maxSet = new TreeSet<>(comparator.reversed());

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k - 1; i++) {
            addNumber(i);
        }

        for (int i = k - 1; i < nums.length; i++) {
            addNumber(i);
            if (minSet.size() == maxSet.size()) {
                result[i - k  + 1] =  (double)nums[maxSet.first()] + ((double)nums[minSet.first()] - (double)nums[maxSet.first()]) / 2;
            } else {
                result[i - k + 1] = nums[maxSet.first()] / 1.0;
            }
            removeNumber(i - k + 1);
        }

        return result;
    }
}
