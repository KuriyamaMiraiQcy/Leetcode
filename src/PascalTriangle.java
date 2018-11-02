import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        res.add(prev);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < prev.size(); j++) {
                temp.add(prev.get(j) + prev.get(j - 1));
            }
            temp.add(1);
            res.add(temp);
            prev = temp;
        }
        return res;
    }
}
