package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int end = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while (j < end && nums[j] + nums[end] > target) {
                    --end;
                }
                if (j == end) {
                    break;
                }
                if (nums[j] + nums[end] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[end]));
                }
            }
        }
        return res;
    }
}
