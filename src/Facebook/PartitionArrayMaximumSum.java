package Facebook;

public class PartitionArrayMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            int max = arr[i - 1];
            for (int j = i - 1; j >= Math.max(i - k + 1, 0); j--) {

                dp[i] = Math.max(dp[i], dp[j + 1] + max * (i - j));
                max = Math.max(max, arr[j - 1]);
            }
        }
        return dp[arr.length];
    }
}
