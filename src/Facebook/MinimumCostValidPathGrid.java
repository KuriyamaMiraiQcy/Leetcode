package Facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinimumCostValidPathGrid {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    class State {
        int i;
        int j;
        int cost;
        State(int i, int j) {
            this.i = i;
            this.j = j;
            this.cost = Integer.MAX_VALUE;
        }
    }

    int width, length;
    public int minCost(int[][] grid) {
        width = grid[0].length;
        length = grid.length;
        HashMap<Integer, State> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                map.put(calculate(i, j), new State(i, j));
            }
        }

        map.get(0).cost = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(map.get(0));
        HashSet<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            visited.add(calculate(curr.i, curr.j));
            if (curr.i == length - 1 && curr.j == width - 1) {
                return curr.cost;
            }
            for (int i = 0; i < 4; i++) {
                if (curr.i + directions[i][0] < 0 || curr.i + directions[i][0] >= length || curr.j + directions[i][1] < 0
                        || curr.j + directions[i][1] >= width || visited.contains(calculate(curr.i + directions[i][0],curr.j + directions[i][1]))) {
                    continue;
                }
                int extra = 1;
                if (i + 1 == grid[curr.i][curr.j]) {
                    extra = 0;
                }
                State next = map.get(calculate(curr.i + directions[i][0], curr.j + directions[i][1]));
                if (curr.cost + extra < next.cost) {
                    State s = new State(curr.i + directions[i][0], curr.j + directions[i][1]);
                    pq.add(s);
                }
            }
        }
        return map.get(calculate(length - 1, width - 1)).cost;
    }

    private int calculate(int i, int j) {
        return i * width + j;
    }

    public static void main(String[] args) {
        MinimumCostValidPathGrid grid = new MinimumCostValidPathGrid();
        grid.minCost(new int[][]{{1,1,3}, {3,2,2}, {1,1,4}});
    }
}
