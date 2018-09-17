import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for (Integer n: nums) {
            set.add(n);
        }

        List<List<Integer>> results = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                int left = 0 - sum;
                if (set.contains(left)) {
                    LinkedList<Integer> result = new LinkedList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(left);
                    results.add(result);
                }
            }
        }

        return results;
    }
}
