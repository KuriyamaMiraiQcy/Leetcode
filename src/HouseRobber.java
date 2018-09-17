public class HouseRobber {
    public int rob(int[] nums) {
        int[][] memory = new int[2][nums.length];
        memory[0][nums.length - 1] = nums[nums.length - 1];
        memory[0][nums.length - 2] = 0;
        memory[0][nums.length - 3] = nums[nums.length - 1];

        memory[1][nums.length - 2] = nums[nums.length - 2];
        memory[1][nums.length - 1] = 0;

        for (int i = nums.length - 4; i >= 0; i--) {
            memory[0][i] = Math.max(memory[0][i + 2], memory[0][i + 3]);
        }
    }
}
