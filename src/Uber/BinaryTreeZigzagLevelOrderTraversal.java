package Uber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> value = new ArrayDeque<>();
        ArrayDeque<Integer> level = new ArrayDeque<>();

        LinkedList<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        value.add(root);
        level.add(1);
        int prev = 1;
        ArrayList<Integer> levelOrder = new ArrayList<>();

        while (value.size() != 0) {
            TreeNode temp = value.pop();
            int levelNum = level.pop();
            if (levelNum != prev) {
                if (prev % 2 == 1) {
                    levelOrder = reverse(levelOrder);
                }
                res.add(levelOrder);
                levelOrder = new ArrayList<>();
                prev = levelNum;
            }
            levelOrder.add(temp.val);
            if (temp.left != null) {
                value.add(temp.left);
                level.add(levelNum + 1);
            }
            if (temp.right != null) {
                value.add(temp.right);
                level.add(levelNum + 1);
            }


        }
        if (prev % 2 == 0) {
            levelOrder = reverse(levelOrder);
        }
        res.add(levelOrder);
        return res;
    }

    private ArrayList<Integer> reverse(ArrayList<Integer> l) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = l.size() - 1; i >= 0; i--) {
            result.add(l.get(i));
        }
        return result;
    }
}
