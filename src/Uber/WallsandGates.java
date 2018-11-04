package Uber;
import java.util.ArrayDeque;

public class WallsandGates {
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    BFS(rooms, i, j);
                }
            }
        }
    }

    private void BFS(int[][] board, int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.push(new int[]{i,j});

        while (queue.size() != 0) {
            int[] index = queue.pop();
            for (int[] direct:directions) {
                int newI = index[0] + direct[0];
                int newJ = index[1] + direct[1];

                if (newI < 0 || newI >= board.length || newJ < 0 || newJ >= board[0].length) {
                    continue;
                }

                if (board[newI][newJ] == -1) {
                    continue;
                }

                if (board[index[0]][index[1]] + 1 >= board[newI][newJ]) {
                    continue;
                }

                board[newI][newJ] = board[index[0]][index[1]] + 1;
                queue.push(new int[]{newI, newJ});
            }
        }
    }
}
