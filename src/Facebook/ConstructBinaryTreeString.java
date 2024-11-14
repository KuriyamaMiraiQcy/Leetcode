package Facebook;

import Uber.TreeNode;

public class ConstructBinaryTreeString {
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) return null;
        int first = s.indexOf('(');
        if (first == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, first)));
        int count = 0, start = first;
        for (int i = first; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0 && start == first) {
                root.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            } else if (count == 0) {
                root.right = str2tree(s.substring(start + 1, i));
            }
        }
        return root;
    }
}
