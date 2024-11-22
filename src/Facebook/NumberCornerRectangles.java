package Facebook;

public class NumberCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int[] masks = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int col = 0; col < grid[i].length; col++) {
                masks[i] |= grid[i][col] << col;
            }
        }

        int res = 0;
        for (int row = 0; row < masks.length; row++) {
            for (int i = row + 1; i < masks.length; i++) {
                int result = masks[row] & masks[i];
                if (result == 0) {
                    continue;
                }
                int count = 0;
                while (result != 0) {
                    count += result & 1;
                    result = result >> 1;
                }
                res += (count - 1) * count / 2;
            }
        }
        return res;
    }
}
