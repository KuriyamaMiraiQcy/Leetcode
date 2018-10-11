import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class SerializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        String res = new String();

        queue.add(root);

        while (queue.size() != 0) {
            TreeNode parent = queue.poll();

            if (parent == null) {
                res += "null,";
            } else {
                res += Integer.toString(parent.val) + ",";
                queue.add(parent.left);
                queue.add(parent.right);
            }
        }

        res = res.substring(0, res.length() - 1);
        res = "[" +res + "]";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] allElements = data.split(",");
        return recoverTree(allElements, 0);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    private TreeNode recoverTree(String[] elements, int index) {
        if (index > elements.length - 1) {
            return null;
        }
        String s = elements[index];
        if (s.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s));

        node.left = recoverTree(elements, index * 2 + 1);
        node.right = recoverTree(elements, index * 2 + 2);
        return node;
    }

    public static void main(String[] args) {
        SerializeBST a = new SerializeBST();

        TreeNode root = a.deserialize("[1,2,3,null,null,null,4]");
        System.out.println(a.serialize(root));
    }
}
