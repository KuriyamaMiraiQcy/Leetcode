import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 1; i < start.length; i++) {
            if (start[i] < end[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
