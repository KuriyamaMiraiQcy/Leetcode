package Facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}, {-1, 1}, {0, 1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return curr[2];
            }
            for (int[] dir : dirs) {
                if (isValid(row + dir[0], col + dir[1], grid.length) && grid[row + dir[0]][col + dir[1]] != 1) {
                    queue.offer(new int[]{row + dir[0], col + dir[1], curr[2] + 1});
                    grid[row + dir[0]][col + dir[1]] = 1;
                }
            }
        }
        return -1;
    }

    private boolean isValid(int row, int col, int n) {
        return  row >= 0 && row < n && col >= 0 && col < n;
    }
}
