public class FindMinFibonacciNumbers {
    public int findMinFibonacciNumbers(int k) {
        int[] dp =new int[60];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < 60; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int count = 0;
        while (k > 0) {
            int num = findMinF(dp, k);
            k-= num;
            count++;
        }
        return count;
    }

    private int findMinF(int[] dp, int k) {
        int start = 0;
        int end = dp.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return dp[start - 1];
    }
}
