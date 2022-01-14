import java.util.HashMap;
import java.util.HashSet;

public class canIWin {
    int desiredTotal;
    HashMap<String, Boolean> visited;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        StringBuilder state = new StringBuilder(maxChoosableInteger);
        for (int i = 0; i < maxChoosableInteger; i++) {
            state = state.append("0");
        }
        this.desiredTotal = desiredTotal;
        visited = new HashMap<>();
        return dfs(true,0,state);
    }

    private boolean dfs(boolean first, int count, StringBuilder state) {
        if (count >= this.desiredTotal) {
            visited.put(state.toString(), !first);
            return !first;
        }
        if (visited.containsKey(state.toString())) {
            return visited.get(state.toString());
        }
        boolean result = false;
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) == '0') {
                if (first) {
                    state.setCharAt(i, '1');
                } else {
                    state.setCharAt(i, '2');
                }
                boolean res = dfs(!first, count+i+1, state);
                state.setCharAt(i, '0');
                if (first && res) {
                    result = true;
                    break;
                }
                if (!res && !first) {
                    result = false;
                    break;
                }
                result |= res;
            }
        }
        visited.put(state.toString(), result);
        return result;
    }

    public static void main(String[] args) {
        canIWin a = new canIWin();
        System.out.println(a.canIWin(18,79));
    }
}
