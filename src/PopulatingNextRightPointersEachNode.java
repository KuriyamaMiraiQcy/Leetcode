import java.util.ArrayDeque;
import java.util.LinkedList;

public class PopulatingNextRightPointersEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() != 0) {
            TreeLinkNode node = queue.removeFirst();
            if (node != null) {
                node.next = queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                if (queue.size() > 0) {
                    queue.add(null);
                }
            }
        }
    }

    //n1 extra space
    public void Connect(TreeLinkNode root) {
        if (root == null) return;
        while (root != null) {
            TreeLinkNode temp = root;
            if (root.left == null) break;//since it is a perfect binary tree
            while (root != null) {//concat in level start from root.left.
                root.left.next = root.right;
                if (root.next != null)
                    root.right.next = root.next.left;
                root = root.next;
            }
            root = temp.left;//go down
        }
    }
}
