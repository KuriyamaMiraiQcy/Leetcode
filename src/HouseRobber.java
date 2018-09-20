public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        int[][] memory = new int[2][nums.length];
        memory[0][nums.length - 1] = nums[nums.length - 1];
        memory[0][nums.length - 2] = 0;
        memory[0][nums.length - 3] = nums[nums.length - 1] + nums[nums.length - 3];

        memory[1][nums.length - 2] = nums[nums.length - 2];
        memory[1][nums.length - 1] = 0;
        memory[1][nums.length - 3] = nums[nums.length - 3];

        for (int i = nums.length - 4; i >= 0; i--) {
            memory[0][i] = Math.max(memory[0][i + 2], memory[0][i + 3]) + nums[i];
            memory[1][i] = Math.max(memory[1][i + 2], memory[1][i + 3]) + nums[i];
        }

        int firstMax = Math.max(memory[0][0], memory[0][1]);
        int secondMax = Math.max(memory[1][0], memory[1][1]);

        return Math.max(firstMax, secondMax);
    }

    public int robBestSolution(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
