package Facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            queue.add(nestedInteger);
            depthQueue.add(1);
        }
        while (!queue.isEmpty()) {
            NestedInteger next = queue.poll();
            int d = depthQueue.poll();
            if (next.isInteger()) {
                sum += d * next.getInteger();
            } else {
                for (NestedInteger nestedInteger : next.getList()) {
                    queue.add(nestedInteger);
                    depthQueue.add(d + 1);
                }
            }
        }
        return sum;
    }
}
