public class LongestIncreasingPathinaMatrix {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] memory = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = BFS(matrix, i , j, memory);
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    private int BFS(int[][] matrix, int i, int j, int[][] memory) {
        if (memory[i][j] != 0) {
            return memory[i][j];
        }

        int max = 0;
        for (int[] direction:directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI < 0 || newJ < 0 || newI >= memory.length || newJ >= memory[0].length || matrix[newI][newJ] <= matrix[i][j]) {
                continue;
            }
            max = Math.max(BFS(matrix, newI, newJ, memory), max);
        }
        memory[i][j] = max;
        return max;
    }
}
