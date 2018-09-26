public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] memory = new int[grid.length][grid[0].length];
        memory[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            memory[i][0] = memory[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            memory[0][i] = memory[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                memory[i][j] = Math.min(memory[i -1][j], memory[i][j - 1]) + grid[i][j];
            }
        }
        return memory[grid.length - 1][grid[0].length -1];
    }
}
