package Uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        if (root == null || root.left == null || root.right == null) {
            return null;
        }

        findDup(root.left, res, map);
        findDup(root.right, res, map);

        return res;
    }

    String findDup(TreeNode n, ArrayList<TreeNode> res, HashMap<String, Integer> map) {
        if (n == null) {
            return "";
        }
        String s = Integer.toString(n.val);
        s = findDup(n.left, res, map) + "," + s + "," + findDup(n.right, res, map);

        if (map.containsKey(s)) {
            if (map.get(s) == 1) {
                res.add(n);
            }
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
        return s;
    }
}
