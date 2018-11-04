package Uber;

import java.util.Arrays;

public class maximumVacationDays {
    //2D DP solution
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (flights.length != days.length || flights.length == 0) {
            return 0;
        }
        int[][] dp = new int[days[0].length][days.length];
        dp[0][0] = days[0][0];
        for (int i = 1; i < days.length; i++) {
            if (flights[0][i] == 1) {
                dp[0][i] = days[i][0];
            } else {
                dp[0][i] = -1;
            }
        }
        int max = 0;

        for (int i = 1; i < days[0].length; i++) {
            for (int j = 0; j < days.length; j++) {
                dp[i][j] = -1;
                dp[i][j] = dp[i - 1][j] > -1?dp[i - 1][j] + days[j][i]:-1;
                for (int k = 0; k < flights.length; k++) {
                    if (flights[k][j] == 1) {
                        dp[i][j] = dp[i - 1][k] > -1?Math.max(dp[i][j], dp[i - 1][k] + days[j][i]):dp[i][j];
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    //DFS with cache
    public int MaxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length, K = days[0].length;
        int[][] cache = new int[K][N];
        for(int i=0; i<K; i++){
            Arrays.fill(cache[i], -1);
        }
        return DFS(flights, days, 0, 0, cache);
    }

    private int DFS(int[][] flights, int[][] days, int k, int i, int[][] cache){
        int N = flights.length, K = days[0].length;
        if(k==K) return 0;
        if(cache[k][i]>=0) return cache[k][i];
        int max = 0;
        for(int j=0; j<N; j++){
            if(i==j || flights[i][j]==1){
                int temp = DFS(flights, days, k+1, j, cache)+days[j][k];
                max = Math.max(max, temp);
            }
        }
        cache[k][i] = max;
        return max;
    }
}
