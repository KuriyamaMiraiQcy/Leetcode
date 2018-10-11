import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    //Best Solution
    public List<Interval> merge(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int prev = 0;
        LinkedList<Interval> res = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (i == intervals.size() -1 || start[i + 1] > end[i]) {
                res.add(new Interval(start[prev], end[i]));
                prev = i + 1;
            }
        }

        return res;
    }
}
