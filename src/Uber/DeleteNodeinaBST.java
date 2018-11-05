package Uber;

public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            int min = findMinValue(root.right);
            root.val = min;
            root.right = deleteNode(root.right, min);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private int findMinValue(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
