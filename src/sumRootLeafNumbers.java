public class sumRootLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sumHelper(root, sb);
        return this.sum;
    }

    private void sumHelper(TreeNode root, StringBuilder sb) {
        sb = sb.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.valueOf(sb.toString());
        }
        if (root.left != null) {
            sumHelper(root.left, sb);
        }
        if (root.right != null) {
            sumHelper(root.right, sb);
        }
        sb.setLength(sb.length() - 1);
    }
}
