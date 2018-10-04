import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        HashMap<String, HashSet<Integer>> map = new HashMap<>();
        LinkedList<int[]> toFill = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String row = "Row:" + Integer.toString(i);
                String col = "Col:" + Integer.toString(j);
                String block = "Block:" + Integer.toString(i / 3) + "/" + Integer.toString(j / 3);
                if (!map.containsKey(row)) {
                    map.put(row, new HashSet<>());
                }
                if (!map.containsKey(col)) {
                    map.put(col, new HashSet<>());
                }
                if (!map.containsKey(block)) {
                    map.put(block, new HashSet<>());
                }
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]);
                    map.get(row).add(val);
                    map.get(col).add(val);
                    map.get(block).add(val);
                } else {
                    int[] pair = new int[]{i, j};
                    toFill.add(pair);
                }
            }
        }

        fill(board, toFill, map);
    }


    boolean fill(char[][] board, LinkedList<int[]> toFill, HashMap<String, HashSet<Integer>> map) {
        if (toFill.size() == 0) {
            return true;
        }
        int[] pair = toFill.remove();
        String row = "Row:" + Integer.toString(pair[0]);
        String col = "Col:" + Integer.toString(pair[1]);
        String block = "Block:" + Integer.toString(pair[0] / 3) + "/" + Integer.toString(pair[1] / 3);
        HashSet<Integer> rowSet = map.get(row);
        HashSet<Integer> colSet = map.get(col);
        HashSet<Integer> blockSet = map.get(block);

        for (int i = 1; i < 10; i++) {
            if (!rowSet.contains(i) && !colSet.contains(i) && !colSet.contains(i)) {
                rowSet.add(i);
                colSet.add(i);
                blockSet.add(i);
                board[pair[0]][pair[1]] = Character.forDigit(i, 10);
                if (fill(board, toFill, map)) {
                    return true;
                }
                rowSet.remove(i);
                colSet.remove(i);
                blockSet.remove(i);
                board[pair[0]][pair[1]] = '0';
            }
        }
        toFill.addFirst(pair);
        return false;
    }

    public static void main(String[] args) {
        SudokuSolver a = new SudokuSolver();
        a.solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }
}
