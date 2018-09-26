import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class StudentAllotment {
    public int[] allocate(int[] schools, int[] scores, int[][] preferences) {
        HashMap<Integer, Integer> remainSeats = new HashMap<>();
        HashMap<Integer, Integer> scoreToIndex = new HashMap<>();

        for (int i = 0; i < schools.length; i++) {
            remainSeats.put(i, schools[i]);
        }

        for (int i = 0; i < scores.length; i++) {
            scoreToIndex.put(scores[i], i);
        }

        Arrays.sort(scores);
        int noSchoolStuCount = 0;

        for (int i = scores.length - 1; i >= 0 ; i--) {
            int index = scoreToIndex.get(scores[i]);
            int[] preference = preferences[index];
            boolean flag = false;

            for (Integer n:preference) {
                int remain = remainSeats.get(n);
                if (remain > 0) {
                    flag = true;
                    remainSeats.put(n, remain - 1);
                    break;
                }
            }

            if (!flag) {
                noSchoolStuCount += 1;
            }
        }

        int leftSeats = 0;

        for (Integer n:remainSeats.keySet()) {
            int left = remainSeats.get(n);
            if (left > 0) {
                leftSeats += left;
            }
        }

        int[] res = new int[2];
        res[0] = leftSeats;
        res[1] = noSchoolStuCount;
        return res;
    }

    public static void main(String[] args) {
        /*StudentAllotment a = new StudentAllotment();
        int[] schools = new int[]{1,3,1,2};
        int[] scores = new int[]{990,780,830,860,920};
        int[][] preferences = new int[][]{
                {3,2,1},
                {3,0,0},
                {2,0,1},
                {0,1,3},
                {0,2,3}
        };

        int[] res = a.allocate(schools, scores,preferences);
        for (Integer n:res) {
            System.out.println(n);
        }*/

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String d = input.nextLine();
            String[] m = d.split("\\s+");
            for (String str:m) {
                System.out.println(Integer.parseInt(str));
            }
        }
    }
}
