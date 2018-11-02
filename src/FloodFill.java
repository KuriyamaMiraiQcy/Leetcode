public class FloodFill {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        DFS(image, sr, sc, target, newColor);
        return image;
    }

    private void DFS(int[][] image, int i, int j, int target, int newColor) {
        if (image[i][j] != target) {
            return;
        }
        image[i][j] = newColor;
        for (int[] direction:directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI < 0 || newI >= image.length || newJ < 0 || newJ >= image[0].length) {
                continue;
            }
            DFS(image, newI, newJ, target, newColor);
        }

    }

    public static void main(String[] s) {
        FloodFill a= new FloodFill();
        a.floodFill(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 3}, {1, 0, 1, 3}}, 1, 1, 2);
    }
}
