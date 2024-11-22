package Facebook;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {
    class Solution {
        int[] sum;
        public Solution(int[] w) {
            sum = new int[w.length];
            int s = 0;
            for (int i = 0; i < w.length; i++) {
                s += w[i];
                sum[i] = s;
            }
        }

        public int pickIndex() {
            Random rand = new Random();
            int n = rand.nextInt(sum[sum.length - 1]);
            int index = Arrays.binarySearch(sum, n);
            if (index >= 0) {
                return index;
            }
            return -(index + 1);
        }
    }
}
