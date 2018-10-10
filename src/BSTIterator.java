public class BSTIterator {
    TreeNode root;
    TreeNode next;
    int prev;
    public BSTIterator(TreeNode root) {
        this.root = root;
        next = null;
        prev = Integer.MIN_VALUE;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return search(root);
    }

    private boolean search(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val > prev) {
            if (!search(root.left)) {
                prev = root.val;
                next = root;
            }
            return true;
        }
        if (root.val < prev) {
            return search(root.right);
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return next.val;
    }
}
