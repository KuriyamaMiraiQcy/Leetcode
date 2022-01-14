import java.util.HashSet;

public class frogJump {
    public boolean canCross(int[] stones) {
        if (stones[1] > 1) {
            return false;
        }
        int[][] dp = new int[stones.length][stones.length];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            HashSet<Integer> dis = new HashSet<>();
            int maxDis = 0;
            for (int j = i - 1; j >=0 ; j--) {
                if (dp[j][i] > 0) {
                    dis.add(dp[j][i]);
                    maxDis = Math.max(maxDis, dp[j][i]);
                }
            }
            for (int j = i + 1; j < dp.length; j++) {
                int distance = stones[j] - stones[i];
                if (distance > maxDis + 1) {
                    break;
                }
                if (dis.contains(distance) || dis.contains(distance - 1) || dis.contains(distance + 1)) {
                    dp[i][j] = distance;
                }
            }
        }
        for (int i = 0; i < dp.length - 1; i++) {
            if (dp[i][dp.length - 1] != 0) {
                return true;
            }
        }
        return false;
    }
}
