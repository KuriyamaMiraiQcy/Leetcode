import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        int depth = depth(root);
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < depth; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < Math.pow(2, depth) - 1; j++) {
                list.add(new String());
            }
            res.add(list);
        }

        add(res, root, 0, 0, (int)Math.pow(2, depth) - 2);
        return res;
    }

    private void add(List<List<String>> res, TreeNode root, int depth, int start, int end) {
        if (depth >= res.size() || root == null) {
            return;
        }
        int index = (start + end) / 2;
        res.get(depth).set(index, Integer.toString(root.val));
        add(res, root.left, depth + 1, start, index - 1);
        add(res, root.right, depth + 1, index + 1, end);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;

        PrintBinaryTree a = new PrintBinaryTree();
        a.printTree(root);
    }
}
