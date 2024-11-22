package Facebook;

import Uber.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        queue.add(new TreeNode(-101));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == -101 ) {
                if (!queue.isEmpty()) {
                    queue.add(node);
                    continue;
                }
                break;
            }
            if (queue.peek().val == -101) {
                result.add(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }
}
