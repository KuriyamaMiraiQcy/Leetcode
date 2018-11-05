package Uber;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int start = 0;

        while (start < intervals.size() && intervals.get(start).end < newInterval.start) {
            res.add(intervals.get(start));
            start++;
        }

        if (start == intervals.size()) {
            res.add(newInterval);
            return res;
        }
        int newstart = Math.min(newInterval.start, intervals.get(start).start);

        while (start < intervals.size() && intervals.get(start).start <= newInterval.end) {
            start++;
        }

        if (start == 0) {
            res.add(newInterval);
        } else {
            int newEnd = Math.max(intervals.get(start - 1).end, newInterval.end);
            res.add(new Interval(newstart, newEnd));
        }

        while (start < intervals.size()) {
            res.add(intervals.get(start));
            start++;
        }

        return res;
    }
}
