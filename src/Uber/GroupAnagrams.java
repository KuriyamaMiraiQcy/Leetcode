package Uber;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> sets = new HashMap<>();

        for (String s:strs) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (map.keySet().contains(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            if (sets.containsKey(map)) {
                sets.get(map).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                sets.put(map, list);
            }
        }

        for (HashMap<Character, Integer> set:sets.keySet()) {
            res.add(sets.get(set));
        }

        return res;
    }

    //quicker solution
    public List<List<String>> GroupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
