package Facebook;

import java.util.HashMap;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0, maxCount = 0;
        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                maxCount = 1;
            } else if (map.get(c) == max) {
                maxCount++;
            }
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}
