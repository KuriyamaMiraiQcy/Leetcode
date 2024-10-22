package Facebook;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> tasks = new Stack<>();
        Stack<Integer> starts = new Stack<>();
        int[] res = new int[n];

        for (String log : logs) {
            String[] l = log.split(":");
            if (Objects.equals(l[1], "start")) {
                if (!tasks.isEmpty()) {
                    res[tasks.peek()] += Integer.parseInt(l[2]) - starts.peek();
                }
                tasks.push(Integer.parseInt(l[0]));
                starts.push(Integer.parseInt(l[2]));
            } else {
                int task = tasks.pop();
                res[task] += Integer.parseInt(l[2]) - starts.pop() + 1;
                if (!tasks.isEmpty()) {
                    starts.pop();
                    starts.push(Integer.parseInt(l[2]) + 1);
                }
            }
        }
        return res;
    }
}
