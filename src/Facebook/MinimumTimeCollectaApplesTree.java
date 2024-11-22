package Facebook;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeCollectaApplesTree {
    List<Integer>[] graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        return Math.max(dfs(hasApple, 0, -1) - 2, 0);
    }

    private int dfs(List<Boolean> hasApple, int i, int parent) {
        int result = 0;
        for (int child : graph[i]) {
            if (child != parent) {
                result += dfs(hasApple, child, parent);
            }
        }
        return result + ((result != 0 || hasApple.get(i)) ? 2 : 0);
    }
}
