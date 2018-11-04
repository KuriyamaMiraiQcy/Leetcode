package Uber;

public class WordSearch {
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (DFS(board, visited, 0, i, j, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean DFS(char[][] board, boolean[][] visited, int index, int i, int j, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        for (int[] direct:directions) {
            int newI = i + direct[0];
            int newJ = j + direct[1];

            if (DFS(board, visited, index + 1, newI, newJ, word)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
