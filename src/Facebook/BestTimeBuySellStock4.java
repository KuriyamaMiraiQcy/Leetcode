package Facebook;

public class BestTimeBuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = Math.min(k, n / 2);
        if ( k == 0) {
            return 0;
        }
        int[][] dp = new int[k][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);

            }
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}
