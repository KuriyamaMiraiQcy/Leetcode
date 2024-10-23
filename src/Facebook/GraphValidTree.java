package Facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer> visited = new HashSet<>();
        if (n == 1) return true;
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            HashSet<Integer> set = adj.getOrDefault(edge[0], new HashSet<>());
            set.add(edge[1]);
            adj.put(edge[0], set);
            set = adj.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[0]);
            adj.put(edge[1], set);
        }


        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int u = q.poll();
            visited.add(u);
            if (!adj.containsKey(u)) {
                return false;
            }
            for (int v : adj.get(u)) {
                if (visited.contains(v)) {
                    return false;
                }
                q.add(v);
                visited.add(v);
                adj.get(v).remove(u);
            }
        }


        return visited.size() == n;
    }
}
