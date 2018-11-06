package Uber;

public class FlattenBinaryTreeLinkedList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        while(root != null){
            if(root.left != null) {//If there is no left child, skip this loop.
                TreeNode pre = predecessor(root.left);
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }
    private TreeNode predecessor (TreeNode root){
        if(root.right == null) return root;
        return predecessor(root.right);
    }
}
