import java.util.HashMap;
import java.util.HashSet;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        if (tree.length < 3) {
            return tree.length;
        }

        int end = 2;
        int maxLength = 2;
        int first = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(tree[0], 0);
        map.put(tree[1], 1);

        while (end < tree.length) {
            if (map.containsKey(tree[end])) {
                map.put(tree[end], end);
            } else {
                if (map.size() < 2) {
                    map.put(tree[end], end);
                } else {
                    maxLength = Math.max(maxLength, end - first);
                    int lastOccurance = Integer.MAX_VALUE;
                    for (Integer n:map.keySet()) {
                        lastOccurance = Math.min(lastOccurance, map.get(n));
                    }
                    map.remove(lastOccurance);
                    for (Integer n:map.keySet()) {
                        first = map.get(n);
                    }
                    map.put(tree[end], end);
                }
            }

            end++;
        }

        return Math.max(maxLength, end - first);
    }

    public static void main(String[] args) {
        FruitIntoBaskets a = new FruitIntoBaskets();
        System.out.println(a.totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
    }
}
