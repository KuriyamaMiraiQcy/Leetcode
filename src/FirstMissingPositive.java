public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int length = nums.length;
        boolean[] cur = new boolean[length + 1];
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length && nums[i] > 0) {
                cur[nums[i]] = true;
            }
        }

        for (int i = 1; i < cur.length; i++) {
            if (!cur[i]) {
                return i;
            }
        }
        return length + 1;
    }
}
