import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) {
            return res;
        }

        HashMap<String, List<String>> patterns = new HashMap<>();
        List<String> singleOne = new ArrayList<>();

        for (String s:strings) {
            if (s.length() == 1) {
                singleOne.add(s);
            } else {
                String str = "";
                for (int i = 1; i < s.length(); i++) {
                    str += (s.charAt(i) - s.charAt(i - 1) + 26) % 26 + ",";
                }
                if (!patterns.containsKey(str)) {
                    patterns.put(str, new ArrayList<>());
                }
                patterns.get(str).add(s);
            }
        }
        res.addAll(patterns.values());
        if (!singleOne.isEmpty()) {
            res.add(singleOne);
        }
        return res;
    }
}
