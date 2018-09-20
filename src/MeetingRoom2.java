public class MeetingRoom2 {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        int prev = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (i == intervals.length - 1 || start[i] > end[prev])
        }
    }
}
