package Uber;

import java.util.*;

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

    //in-order traversal with stack
    public int KthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }
}
