package Facebook;

import Uber.TreeNode;

public class InorderSuccessorBst {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result;
        if (p.right != null) {
            result = p.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        }
        result = null;
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                result = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return result;
    }
}
