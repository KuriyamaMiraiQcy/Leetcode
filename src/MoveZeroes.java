public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int start = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start] = nums[i];
                start++;
            }
        }
        for (int j = start; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
