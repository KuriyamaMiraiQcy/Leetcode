import java.util.ArrayDeque;
import java.util.HashMap;

public class LRUCache {
    ArrayDeque<Integer> queue;
    HashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        queue = new ArrayDeque<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            int k = queue.poll();
            map.remove(k);
        } else if (map.containsKey(key)) {
            queue.remove(key);
        }
        map.put(key, value);
        queue.add(key);
    }
}
