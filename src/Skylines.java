public class Skylines {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int before = 0;
        int[] topView = new int[length];
        int[] leftView = new int[length];

        for (int i = 0; i < length; i += 1) {
            int topMax = 0;
            int leftMax = 0;
            for (int j = 0; j < length; j += 1) {
                if (grid[i][j] > leftMax) {
                    leftMax = grid[i][j];
                }

                if (grid[j][i] > topMax) {
                    topMax = grid[j][i];
                }
                before += grid[i][j];
            }
            leftView[i] = leftMax;
            topView[i] = topMax;
        }

        int cur = 0;
        for (int i = 0; i < length; i += 1) {
            for (int j = 0; j < length; j+= 1) {
                int left = leftView[i];
                int top = topView[j];
                int min = Math.min(left, top);

                if (grid[i][j] < min) {
                    grid[i][j] = min;
                }
                cur += grid[i][j];
            }
        }

        return cur - before;
    }
}
