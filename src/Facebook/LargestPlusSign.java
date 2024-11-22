package Facebook;

import java.util.Arrays;
import java.util.HashSet;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        HashSet<Integer> zeros = new HashSet<>();
        for (int[] mine : mines) {
            zeros.add(mine[0] * n + mine[1]);
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (zeros.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(count, dp[i][j]);
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (zeros.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(count, dp[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (zeros.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(count, dp[j][i]);
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (zeros.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(count, dp[j][i]);
                res = Math.max(res, dp[j][i]);
            }
        }
        return res;
    }
}
