import java.util.ArrayList;

public class Google1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (Integer n:A) {
            boolean addNewLine = true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > n) {
                    list.set(i, n);
                    addNewLine = false;
                    break;
                }
            }
            if (addNewLine) {
                list.add(n);
            }
        }

        return list.size();
    }
}
