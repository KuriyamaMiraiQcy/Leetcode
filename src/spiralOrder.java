import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int direction = 0;
        int length = matrix.length;
        int width = matrix[0].length;
        boolean[][] visited = new boolean[length][width];
        int startI = 0;
        int startJ = 0;
        visited[0][0] = true;

        ArrayList<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);

        while (res.size() != length * width) {
            switch (direction) {
                case 0: {
                    for (int i = startJ + 1; i < width; i++) {
                        if (visited[startI][i]) {
                            break;
                        }
                        res.add(matrix[startI][i]);
                        visited[startI][i] = true;
                        startJ++;
                    }
                }
                case 1: {
                    for (int i = startI + 1; i < length; i++) {
                        if (visited[i][startJ]) {
                            break;
                        }
                        res.add(matrix[i][startJ]);
                        visited[i][startJ] = true;
                        startI++;
                    }
                }
                case 2: {
                    for (int i = startJ - 1; i >= 0; i--) {
                        if (visited[startI][i]) {
                            break;
                        }
                        res.add(matrix[startI][i]);
                        visited[startI][i] = true;
                        startJ--;
                    }
                }
                case 3: {
                    for (int i = startI - 1; i >= 0; i--) {
                        if (visited[i][startJ]) {
                            break;
                        }
                        res.add(matrix[i][startJ]);
                        visited[i][startJ] = true;
                        startI--;
                    }
                }

                direction = (direction + 1) % 4;
            }
        }

        return res;
    }
}
