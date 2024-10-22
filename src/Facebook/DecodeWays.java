package Facebook;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' > 0) {
                dp[i + 1] += dp[i];
            }
            if (s.charAt(i-1) != '0' && (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
