import java.util.HashMap;
import java.util.HashSet;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    String row = "Row:" + Integer.toString(i);
                    String col = "Col:" + Integer.toString(j);
                    String block = "Block:" + Integer.toString(i / 3) + Integer.toString(j / 3);

                    if (!check(row, map, num)) {
                        return false;
                    }
                    if (!check(col, map, num)) {
                        return false;
                    }
                    if (!check(block, map, num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean check(String str, HashMap<String, HashSet<Integer>> map, int n) {
        if (map.containsKey(str)) {
            if (map.get(str).contains(n)) {
                return false;
            }
            map.get(str).add(n);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(n);
            map.put(str, set);
        }
        return true;
    }
}
