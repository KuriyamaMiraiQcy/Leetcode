public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if ((long)root.val <= min || (long)root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
