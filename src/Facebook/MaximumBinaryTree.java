package Facebook;

import Uber.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildHelper(nums, 0, nums.length - 1);
    }

    private TreeNode buildHelper(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = buildHelper(nums, start, max - 1);
        root.right = buildHelper(nums, max + 1, end);
        return root;
    }
}
