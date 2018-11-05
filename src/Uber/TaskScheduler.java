package Uber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char ch:tasks) {
            count[ch - 'a']++;
        }

        Arrays.sort(count);
        int i = 25;
        int max = count[25];
        for (; i >= 0; i--) {
            if (count[i] < max) {
                break;
            }
        }

        return (count[25] - 1) * (n + 1) + 25 -i;
    }
}
