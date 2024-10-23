package Facebook;

import java.util.HashSet;

public class WallsGates {
    private static int INF = Integer.MAX_VALUE;
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    HashSet<Integer> visited = new HashSet<>();
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == INF) {
                    dfs(rooms, i, j);
                }
            }
        }
    }

    private int dfs(int[][] rooms, int i, int j) {
        if (i >= rooms.length || j >= rooms[i].length || rooms[i][j] == -1) {
            return -1;
        }
        if (rooms[i][j] != INF && rooms[i][j] >= 0) {
            return rooms[i][j] + 1;
        }

        visited.add(i * rooms.length + j);
        int result = INF;
        for (int[] direction : directions) {
            if (!visited.contains((i + direction[0])* rooms.length + j + direction[1])) {
                int length = dfs(rooms, i + direction[0], j + direction[1]);
                if (length > 0) {
                    result = Math.min(result, length);
                }
                ;
            }
        }
        rooms[i][j] = result;
        return result;
    }
}
