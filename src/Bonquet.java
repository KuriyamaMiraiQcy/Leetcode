public class Bonquet {
    public static int flowerBouquets(int p, int q, String s) {
        // Write your code here
        if (s.length() <= 1) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int a = s.charAt(0) - '0';
        int b = s.charAt(1) - '0';
        if (a + b == 1) {
            dp[1] = q;
        }
        if (dp.length == 2) {
            return dp[1];
        }
        int c = s.charAt(2) - '0';
        if (a + b + c == 0) {
            dp[2] = p;
        } else if (a + b + c < 3) {
            dp[2] = q;
        }

        for (int i = 3; i < dp.length; i++) {
            if (s.charAt(i) == '0') {
                boolean change = false;
                if (s.charAt(i - 1) == '0' && s.charAt(i - 2) == '0') {
                    dp[i] = dp[i - 3] + p;
                    change = true;
                }
                if (s.charAt(i) == '0' && s.charAt(i - 1) == '1') {
                    dp[i] = Math.max(dp[i], dp[i - 2] + q);
                    change = true;
                }
                if (!change) {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 2] + q;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }



    public static void main(String[] args) {
        System.out.println(Bonquet.flowerBouquets(2, 3, "001110000100"));

    }
}
