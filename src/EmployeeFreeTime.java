import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();

        for (List<Interval> sche:schedule) {
            for (Interval inter:sche) {
                startTime.add(inter.start);
                endTime.add(inter.end);
            }
        }

        Collections.sort(startTime);
        Collections.sort(endTime);

        List<Interval> res = new ArrayList<>();

        for (int i = 1; i < startTime.size() - 1; i++) {
            if (startTime.get(i) > endTime.get(i - 1)) {
                Interval temp = new Interval(endTime.get(i - 1), startTime.get(i));
                res.add(temp);
            }
        }

        return res;
    }
}
