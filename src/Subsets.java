import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            DFS(i, nums, res, new ArrayList<>());
        }
        res.add(new ArrayList<>());
        return res;
    }

    public void DFS(int index, int[] nums, List<List<Integer>> res, ArrayList<Integer> result) {
        if (index == nums.length) {
            res.add((ArrayList<Integer>)result.clone());
            return;
        }
        result.add(nums[index]);
        for (int i = index + 1; i <= nums.length; i++) {
            DFS(i, nums, res, result);
        }
        result.remove(result.size() - 1);
    }
}
