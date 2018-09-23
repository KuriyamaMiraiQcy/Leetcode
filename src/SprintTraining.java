import java.util.List;

public class SprintTraining {
    public static int getMostVisited(int n, List<Integer> sprints) {
        // Write your code here
        int[] num = new int[n];
        for (int i = 0; i < sprints.size() - 1; i++) {
            int start = sprints.get(i);
            int end = sprints.get(i + 1);

            if (start <= end) {
                for (int j = start - 1; j < end; j ++) {
                    num[j] += 1;
                }
            } else {
                for (int j = end - 1; j < start; j++) {
                    num[j] += 1;
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }

        return index + 1;
    }
}
