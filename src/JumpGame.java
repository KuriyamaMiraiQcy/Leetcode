public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[dp.length - 1] = true;
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < dp.length && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
            if (!dp[i]) {
                return false;
            }
        }
        return true;
    }
}
