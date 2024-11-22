package Facebook;

import java.util.ArrayList;
import java.util.List;

public class DiameterNaryTree {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    int result = 0;
    public int diameter(Node root) {
        dfs(root);
        return result;
    }

    private int dfs(Node root) {
        int max = 0, max2 = 0;
        for (Node child : root.children) {
            int depth = dfs(child) + 1;
            if (max < depth) {
                max2 = max;
                max = depth;
            } else if (max2 < depth) {
                max2 = depth;
            }
        }
        result = Math.max(result, max + max2);
        return max;
    }
}
