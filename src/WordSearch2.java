import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordSearch2 {
    int[][] directions = new int[][]{{0, -1}, {-1,0}, {0,1}, {1, 0}};


    public List<String> findWords(char[][] board, String[] words) {

        HashSet<String> res = new HashSet<>();
        for (String str:words) {
            char start = str.charAt(0);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == start) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        visited[i][j] = true;
                        if (search(str, board, 1, i, j, visited)) {
                            res.add(str);
                        }
                    }
                }
            }
        }

        LinkedList<String> result = new LinkedList<>();
        for (String s:res) {
            result.add(s);
        }
        return result;
    }

    private boolean search(String str, char[][] board, int index, int i, int j, boolean[][] visited) {
        if (index == str.length()) {
            return true;
        }
        for (int[] direction:directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI < 0 || newJ < 0 || newI >= board.length || newJ >= board[0].length) {
                continue;
            }
            if (board[newI][newJ] == str.charAt(index) && !visited[newI][newJ]) {
                if (search(str, board, index + 1, newI, newJ, visited)) {
                    visited[newI][newJ] = true;
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch2 a = new WordSearch2();
        a.findWords(new char[][]{{'a', 'b'},{'a','a'}}, new String[]{"aaa","aba","aaba","baa","aaab","aaaa", "bab"});
    }
}
