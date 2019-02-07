import java.util.Arrays;

public class TwoSumClosest {
    public int twoSumCloset(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        int diff = Integer.MAX_VALUE;

        while (low < high) {
            int sum = nums[low] + nums[high];

            if (sum > target) {
                high--;
            } else {
                low++;
            }

            diff = Math.min(diff, Math.abs(sum - target));
        }

        return diff;
    }
}
