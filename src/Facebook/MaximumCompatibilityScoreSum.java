package Facebook;

public class MaximumCompatibilityScoreSum {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        int[][] points = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int point = 0;
                for (int k = 0; k < students[i].length; k++) {
                    point += students[i][k] == mentors[j][k] ? 1 : 0;
                }
                points[i][j] = point;
            }
        }
        int[] dp = new int[1 << n];

        for (int i = 1; i < (1 << n); i++) {
            int count = Integer.bitCount(i);
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    dp[i] = Math.max(dp[i], dp[i ^ (1 << j)] + points[count - 1][j]);
                }
            }
        }
        return dp[dp.length - 1];
    }


}
