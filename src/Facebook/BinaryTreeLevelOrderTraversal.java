package Facebook;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import Uber.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode dummy = new TreeNode(10000);
        queue.add(dummy);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n == dummy) {
                res.add(level);
                level = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.add(dummy);
                }
            } else {
                level.add(n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }

        return res;
    }
}
