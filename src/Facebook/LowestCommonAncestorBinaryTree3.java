package Facebook;

import java.util.HashSet;

public class LowestCommonAncestorBinaryTree3 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    Node lowestCommonAncestor(Node p, Node  q) {
        Node point_p = p;
        Node point_q = q;

        while (point_p != point_q) {
            point_p = point_p.parent != null ? point_p.parent : q;
            point_q = point_q.parent != null ? point_q.parent : p;
        }

        return point_p;
    }
}
