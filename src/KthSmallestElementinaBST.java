import java.util.ArrayDeque;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        inorderTraverse(root, queue);

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.remove();
        }
        return res;
    }

    private void inorderTraverse(TreeNode root, ArrayDeque<Integer> queue) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, queue);
        queue.add(root.val);
        inorderTraverse(root.right, queue);
    }
}
