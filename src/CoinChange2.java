public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int num:coins) {
            if (num <= amount) {
                dp[num] = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            int count = 0;
            for (int num:coins) {
                if (i - num >= 0) {
                    count += dp[i - num];
                }
            }
            dp[i] += count;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 a = new CoinChange2();
        a.change(5, new int[]{1, 2, 5});
    }
}
