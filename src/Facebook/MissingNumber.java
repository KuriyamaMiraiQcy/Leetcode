package Facebook;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int count = (n + 1) * n / 2;

        for (int i = 0; i < nums.length; i++) {
            count -= nums[i];
        }
        return count;
    }
}
