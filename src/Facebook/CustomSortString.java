package Facebook;

import java.util.HashMap;
import java.util.HashSet;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < order.length(); i++) {
            set.add(order.charAt(i));
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            if (map.containsKey(order.charAt(i))) {
                for (int j = map.get(order.charAt(i)); j > 0; j--) {
                    sb.append(order.charAt(i));
                }
            }
        }
        for (char c : map.keySet()) {
            if (map.get(c) < 0) {
                for (int i = 0; i < -map.get(c); i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
