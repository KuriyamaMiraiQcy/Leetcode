package Facebook;

import java.util.ArrayList;
import java.util.Collections;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (is_intersect(intervals[i], newInterval)) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.min(intervals[i][1], newInterval[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        res.add(newInterval);
        Collections.sort(res, (int[] a1, int[] a2) -> a2[0] - a1[0]);
        return res.toArray(new int[res.size()][]);
    }

    private boolean is_intersect(int[] interval, int[] newInterval) {
        return !(interval[1] < newInterval[0]|| interval[0] > newInterval[1]);
    }
}
