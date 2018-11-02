import java.util.ArrayList;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<String> res = new ArrayList<>();
        inOrderTravers(root, res);
        int start = 0;
        int end = res.size() - 1;

        while (start < end) {
            if (!res.get(start).equals(res.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void inOrderTravers(TreeNode root, ArrayList<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return;
        }
        inOrderTravers(root.left, list);
        list.add(String.valueOf(root.val));
        inOrderTravers(root.right, list);
    }

    public static void main(String[] args) {
        SymmetricTree a= new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(2);
        a.isSymmetric(root);
    }
}
