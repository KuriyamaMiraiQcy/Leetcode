import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {
    HashSet<unionNode> roots = new HashSet<>();
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, unionNode> map = new HashMap<>();

        for (int n:nums) {
            if (map.keySet().contains(n)) {
                continue;
            }
            unionNode temp = new unionNode(n);
            map.put(n, temp);
            unionNode prev = null;

            if (!map.keySet().contains(n - 1) && !map.keySet().contains(n + 1)) {
                roots.add(temp);
                continue;
            }
            if (map.keySet().contains(n - 1)) {
                prev = map.get(n - 1);
                union(prev, temp);
            }
            if (map.keySet().contains(n + 1)) {
                prev = map.get(n + 1);
                union(prev, temp);
            }
        }

        int max = 0;
        for (unionNode node:roots) {
            max = Math.max(node.length, max);
        }
        return max;
    }

    private void union(unionNode a, unionNode b) {
        unionNode rootA = a;
        unionNode rootB = b;
        while (rootA.parent != null) {
            rootA = rootA.parent;
        }
        while (rootB.parent != null) {
            rootB = rootB.parent;
        }

        rootB.parent = rootA;
        rootA.length += rootB.length;
        roots.remove(rootB);
    }

    class unionNode {
        int length;
        int val;
        unionNode parent;

        unionNode(int val) {
            this.val = val;
            length = 1;
            parent = null;
        }
    }

    //More simple solution without add new class
    public int LongestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }
}
