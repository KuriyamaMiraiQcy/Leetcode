public class RecoverBST {
    public void recoverTree(TreeNode root) {
        recover(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
    }

    private TreeNode recover(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return null;
        }
        if (root.val < min.val || root.val > max.val){
            return root;
        } else {
            TreeNode left = recover(root.left, min, root);
            TreeNode right = recover(root.right, root, max);
            if (left != null && right != null) {
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
                return null;
            } else if (left != null) {
                return left;
            } else if (right != null) {
                return right;
            }
        }
        return null;
    }
}
