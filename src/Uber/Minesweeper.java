public class Minesweeper {
    int[][] directions = new int[][]{{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';

        } else if (board[i][j] == 'E') {
            DFS(board, i, j);
        }
        return board;
    }

    private int findMines(char[][] board, int i, int j) {
        int count = 0;
        for (int[] direction:directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && (board[newI][newJ] == 'M' || board[newI][newJ] == 'X')) {
                count++;
            }
        }
        return count;
    }

    private void DFS(char[][] board, int i, int j) {
        int num = findMines(board, i, j);
        if (num > 0) {
            board[i][j] = Character.forDigit(num, 10);
            return;
        } else {
            board[i][j] = 'B';
            for (int[] direction : directions) {
                int newI = i + direction[0];
                int newJ = j + direction[1];
                if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && board[newI][newJ] == 'E') {
                    DFS(board, newI, newJ);
                }
            }
        }
    }
}
