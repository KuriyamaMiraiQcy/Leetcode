package Uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates, 0, target, new LinkedList<>(), res);
        return res;
    }

    void DFS(int[] candidates, int index, int target, LinkedList<Integer> formerResult, List<List<Integer>> res) {
        if (target == 0) {
            res.add((LinkedList<Integer>)formerResult.clone());
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                formerResult.add(candidates[i]);
                DFS(candidates, i, target - candidates[i], formerResult, res);
                formerResult.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        combinationSum a = new combinationSum();
        a.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
