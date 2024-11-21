package Facebook;

import java.util.*;

public class MinimumKnightMoves {
    private static int factor = 0x10e6 + 7;
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int minKnightMoves(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }

    private int dfs(int x, int y) {
        if (memo.containsKey(x*factor + y)) {
            return memo.get(x*factor + y);
        }
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x + y == 2) {
            return 2;
        }
        int result = 1 + Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2)), dfs(Math.abs(x - 2), Math.abs(y - 1)));
        memo.put(x*factor + y, result);
        return result;
    }
}
