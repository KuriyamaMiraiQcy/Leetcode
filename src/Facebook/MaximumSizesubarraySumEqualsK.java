package Facebook;

import java.util.HashMap;

public class MaximumSizesubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                result = i + 1;
            }
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}
