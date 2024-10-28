package Facebook;

public class LongestIncreasingPathMatrix {
    int[][] result;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        result = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (result[i][j] == 0) {
                    dfs(matrix, i, j);
                }
                res = Math.max(res, result[i][j]);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        int length = 1;
        for (int[] direction : directions) {
             if (i + direction[0] >= 0 && i + direction[0] < matrix.length && j + direction[1] >= 0 && j + direction[1] < matrix[0].length && matrix[i][j] < matrix[i + direction[0]][j + direction[1]]) {
                 if (result[i + direction[0]][j + direction[1]] == 0) {
                     length = Math.max(length, dfs(matrix, i + direction[0], j + direction[1]) + 1);
                 } else {
                     length = Math.max(length, result[i + direction[0]][j + direction[1]] + 1);
                 }
             }
        }
        result[i][j] = length;
        return length;
    }
}
