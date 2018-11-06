package Uber;
import java.util.*;

public class CloneGraph {
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (!map.containsKey(neighbor.label)) {
                clone.neighbors.add(cloneGraph(neighbor));
            } else{
                clone.neighbors.add(map.get(neighbor.label));
            }
        }
        return clone;
    }

    public UndirectedGraphNode CloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
        HashMap<Integer, UndirectedGraphNode> map = new HashMap(); //store visited nodes

        map.put(newNode.label, newNode); //add first node to HashMap

        LinkedList<UndirectedGraphNode> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue

        while (!queue.isEmpty()) { //if more nodes need to be visited
            UndirectedGraphNode n = queue.pop(); //search first node in the queue
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
            }
        }

        return newNode;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
