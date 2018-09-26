import java.util.ArrayList;
import java.util.HashMap;

public class StandInRow {
    public int solution(int[] A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> min = new HashMap<>();
        int startIndex = 0;

        for (Integer n:A) {
            boolean isInsert = false;
            for (Integer index:min.keySet()) {
                if (n < min.get(index)) {
                    min.put(index, n);
                    list.get(index).add(n);
                    isInsert = true;
                    break;
                }
            }

            if (!isInsert) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(n);
                list.add(l);
                min.put(startIndex, n);
                startIndex++;
            }
        }

        return startIndex;
    }

    public static void main(String[] args) {
        StandInRow a = new StandInRow();
        System.out.println(a.solution(new int[]{5,4,3,6,1}));
    }
}
