package Facebook;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] count = new int[21];
        for (int num : nums) {
            count[num+10]++;
        }
        result = new ArrayList<>();
        dfs(count, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] count, int i, List<Integer> res) {
        if (i == count.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int j = 0; j < count[i]; j++) {
            res.add(i - 10);
        }
        for (int j = 0; j < count[i]; j++) {
            dfs(count, i + 1, res);
            res.remove(res.size() - 1);
        }
        dfs(count, i + 1, res);
    }
}
