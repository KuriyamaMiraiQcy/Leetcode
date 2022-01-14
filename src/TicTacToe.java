import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
    HashMap<Integer, Integer>[] lines;
    HashMap<Integer, Integer>[] columns;
    HashMap<Integer, Integer> leftCross;
    HashMap<Integer, Integer> rightCross;
    public TicTacToe(int n) {
        lines = new HashMap[n];
        columns = new HashMap[n];
        leftCross = new HashMap<>();
        rightCross = new HashMap<>();
    }

    public int move(int row, int col, int player) {
        if (lines[row] == null) {
            lines[row] = new HashMap<>();
        }
        if (columns[col] == null) {
            columns[col] = new HashMap<>();
        }
        lines[row].put(col, player);
        columns[col].put(row, player);
        if (row == col) {
            leftCross.put(row, player);
        }
        if (row + col == lines.length - 1) {
            rightCross.put(row, player);
        }
        if (lines[row].size() == lines.length) {
            boolean win = true;
            for (Map.Entry<Integer, Integer> entry:lines[row].entrySet()) {
                if (entry.getValue() != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return player;
            }
        }
        if (columns[col].size() == columns.length) {
            boolean win = true;
            for (Map.Entry<Integer, Integer> entry:columns[col].entrySet()) {
                if (entry.getValue() != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return player;
            }
        }
        if (leftCross.size() == lines.length) {
            boolean win = true;
            for (Map.Entry<Integer, Integer> entry:leftCross.entrySet()) {
                if (entry.getValue() != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return player;
            }
        }
        if (rightCross.size() == lines.length) {
            boolean win = true;
            for (Map.Entry<Integer, Integer> entry:rightCross.entrySet()) {
                if (entry.getValue() != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return player;
            }
        }
        return 0;
    }
}
