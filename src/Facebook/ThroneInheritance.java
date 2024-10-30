package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThroneInheritance {
    class ListNode {
        String name;
        ListNode child;
        ListNode sibling;
        ListNode(String name) {
            this.name = name;
        }
        boolean isDead = false;
    }

    ListNode root;
    HashMap<String, ListNode> map;
    public ThroneInheritance(String kingName) {
        root = new ListNode(kingName);
        map = new HashMap<String, ListNode>();
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        ListNode node = map.get(parentName);
        ListNode child = new ListNode(childName);
        map.put(childName, child);
        if (node.child == null) {
            node.child = child;
            return;
        }
        node = node.child;
        while (node.sibling != null) {
            node = node.sibling;
        }
        node.sibling = child;
    }

    public void death(String name) {
        map.get(name).isDead = true;
    }

    List<String> result;
    public List<String> getInheritanceOrder() {
        result = new ArrayList<>();
        preorder(root);
        return result;
    }

    private void preorder(ListNode root) {
        if (!root.isDead) {
            result.add(root.name);
        }
        if (root.child != null) {
            preorder(root.child);
        }
        if (root.sibling != null) {
            preorder(root.sibling);
        }
    }
}
