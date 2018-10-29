public class MakingALargeIsland {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int largestIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, DFS(i, j, grid, new boolean[grid.length][grid[0].length]));
                    grid[i][j] = 0;
                }
            }
        }
        return max!=0?max:grid.length*grid[0].length;
    }

    private int DFS(int i, int j, int[][] grid, boolean[][] visited) {
        int count = 0;
        visited[i][j] = true;
        for (int[] direction:directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[0].length || visited[newI][newJ]) {
                continue;
            }
            count += DFS(newI, newJ, grid, visited);
        }
        return 1 + count;
    }
}
