import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int running = -1;
        int id = -1;
        Stack<Integer> pending = new Stack<>();
        int[] res = new int[n];

        for (String str:logs) {
            String[] removed = str.split(":");
            if (removed[1].equals("start")) {
                if (id == -1) {
                    id = Integer.parseInt(removed[0]);
                    running = Integer.parseInt(removed[2]);
                } else {
                    pending.push(id);
                    res[id] += Integer.parseInt(removed[2]) - running;
                    id = Integer.parseInt(removed[0]);
                    running = Integer.parseInt(removed[2]);
                }
            } else {
                if (Integer.parseInt(removed[0]) == id) {
                    res[id] += Integer.parseInt(removed[2]) - running + 1;
                } else {
                    res[Integer.parseInt(removed[0])] = Integer.parseInt(removed[2]) - running + 1;
                }
                if (pending.size() != 0) {
                    id = pending.pop();
                    running = Integer.parseInt(removed[2]) + 1;
                } else {
                    id = -1;
                }
            }
        }
        return res;
    }
}
