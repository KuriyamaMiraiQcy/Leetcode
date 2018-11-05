package Uber;
import java.util.ArrayDeque;
import java.util.HashMap;

public class LRUCache {
    DoubleLinkedListNode head, tail;
    HashMap<Integer, DoubleLinkedListNode> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        head = new DoubleLinkedListNode(0,0, null, null);
        tail = new DoubleLinkedListNode(0, 0, head, head);
        head.next = tail;
        head.prev = tail;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode n = map.get(key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
            addToHead(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            DoubleLinkedListNode tailNode = tail.prev;
            map.remove(tailNode.key);
            deleteNode(tailNode);
            DoubleLinkedListNode n = new DoubleLinkedListNode(key, value, null, null);
            addToHead(n);
            map.put(key, n);
        } else if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
        } else {
            DoubleLinkedListNode n = new DoubleLinkedListNode(key, value, null, null);
            addToHead(n);
            map.put(key, n);
        }
    }

    private void deleteNode(DoubleLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DoubleLinkedListNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class DoubleLinkedListNode {
        int val;
        int key;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;

        DoubleLinkedListNode(int key, int val, DoubleLinkedListNode prev, DoubleLinkedListNode next) {
            this.val = val;
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCache a =new LRUCache(1);
        a.put(2,1);
        a.get(2);
        a.get(2);
        a.put(3,2);
        a.get(2);
    }
}
