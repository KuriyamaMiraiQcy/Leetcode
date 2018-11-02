import java.util.ArrayList;
import java.util.HashMap;

public class ShortestWordDistanceII {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                ArrayList<Integer> lst = new ArrayList<>();
                map.put(words[i], lst);
            }
            map.get(words[i]).add(i);
        }

    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> lst1 = map.get(word1);
        ArrayList<Integer> lst2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        int first = 0;
        int next = 0;

        while (first != lst1.size() && next != lst2.size()) {
            min = Math.min(Math.abs(lst1.get(first) - lst2.get(next)), min);
            if (lst1.get(first) < lst2.get(next)) {
                first++;
            } else {
                next++;
            }
        }
        return min;
    }
}
