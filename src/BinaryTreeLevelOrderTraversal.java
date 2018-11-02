import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        ArrayList<Integer> result = new ArrayList<>();
        while (queue.size() != 0) {
            TreeNode node = queue.removeFirst();
            if (node != null) {
                result.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                res.add(result);
                result = new ArrayList<>();
                if (queue.size() != 0) {
                    queue.add(null);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal a = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(23);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        a.levelOrder(root);
    }
}
