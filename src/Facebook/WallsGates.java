package Facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WallsGates {
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int[] direction : directions) {
                if (loc[0] + direction[0] < 0 || loc[0] + direction[0] >= rooms.length || loc[1] + direction[1] < 0 || loc[1] + direction[1] >= rooms[0].length) {
                    continue;
                }
                if (rooms[loc[0] + direction[0]][loc[1] + direction[1]] > rooms[loc[0]][loc[1]] + 1) {
                    rooms[loc[0] + direction[0]][loc[1] + direction[1]] = rooms[loc[0]][loc[1]] + 1;
                    queue.offer(new int[]{loc[0] + direction[0], loc[1] + direction[1]});
                }
            }
        }
    }

}
