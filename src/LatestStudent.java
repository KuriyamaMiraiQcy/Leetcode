import java.util.*;

public class LatestStudent {
    public String latest(List<List<String>> attendanceData) {
        HashMap<String, LinkedList<Integer>> dateList = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> student = new HashMap<>();
        if (attendanceData.isEmpty()) {
            return "";
        }
        for (List<String> a:attendanceData) {
            if (a.isEmpty()) {
                return "";
            }
        }
        for (List<String> record:attendanceData) {
            String date = record.get(0);
            String name = record.get(1);
            int startTime = Integer.parseInt(record.get(2));
            int arrTime = Integer.parseInt(record.get(3));
            int late = Math.max(arrTime - startTime, 0);

            if (!student.keySet().contains(name)) {
                HashMap<String, Integer> course = new HashMap<>();
                course.put(date, late);
                student.put(name, course);
            } else {
                student.get(name).put(date, late);
            }

            if (dateList.keySet().contains(date)) {
                dateList.get(date).add(late);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(late);
                dateList.put(date, list);
            }
        }

        HashMap<String, Double> avg = new HashMap<>();
        for (String cl:dateList.keySet()) {
            LinkedList<Integer> lst = dateList.get(cl);
            double count = 0;
            double size = lst.size();
            while (lst.size() != 0) {
                int num = lst.remove();
                count += num;
            }

            avg.put(cl, count / size);
        }
        dateList = null;
        double maxLate = 0;
        LinkedList<String> maxLateSName = new LinkedList<>();

        for (String name:student.keySet()) {
            HashMap<String, Integer> stu = student.get(name);
            double stuOverallLateness = calculateLateness(avg,stu);
            if (stuOverallLateness > maxLate) {
                maxLate = stuOverallLateness;
                maxLateSName = new LinkedList<>();
                maxLateSName.add(name);
            } else if (stuOverallLateness == maxLate) {
                maxLateSName.add(name);
            }
        }

        String res = maxLateSName.remove();
        while (maxLateSName.size() != 0) {
            String next = maxLateSName.remove();
            if (res.compareTo(next) > 0) {
                res = next;
            }
        }

        return res;
    }

    private double calculateLateness(HashMap<String, Double> avg, HashMap<String, Integer> stu) {
        double count = 0;
        for (String cl:stu.keySet()) {
            double averageTime = avg.get(cl);
            double lateTime = stu.get(cl);

            if (lateTime > averageTime) {
                count += lateTime - averageTime;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LatestStudent a = new LatestStudent();

    }
}
