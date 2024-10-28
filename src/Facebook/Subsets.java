package Facebook;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int i, List<Integer> res) {
        if (i == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[i]);
        dfs(nums, i + 1, res);
        res.remove(res.size() - 1);
        dfs(nums, i + 1, res);
    }
}
