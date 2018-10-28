package Uber;
import java.util.Arrays;

public class MeetingRoom2 {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int prev = 0;
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (start[i] >= end[prev]) {
                count = Math.max(count, i - prev);
                prev += 1;
            }
            if (i == intervals.length - 1) {
                count = Math.max(count, intervals.length - prev);
            }
        }

        return count;
    }
}
