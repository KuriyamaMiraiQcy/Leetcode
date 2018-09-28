import java.util.*;

public class ReorganizeString {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            if (count.containsKey(S.charAt(i))) {
                count.put(S.charAt(i), count.get(S.charAt(i)) + 1);
            } else {
                count.put(S.charAt(i), 1);
            }
        }

        int max = 0;
        char maxChar = 0;

        for (Character ch:count.keySet()) {
            if (count.get(ch) > max) {
                maxChar = ch;
                max = count.get(ch);
            }
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        int start = 0;
        StringBuilder res = new StringBuilder(S);
        for (int i = 0; i < max; i ++) {
            res.setCharAt(start, maxChar);
            start += 2;
        }

        count.remove(maxChar);

        for (Character ch:count.keySet()) {
            int num = count.get(ch);
            for (int i = 0; i < num; i++) {
                if (start >= S.length()) {
                    start = 1;
                }
                res.setCharAt(start, ch);
                start += 2;
            }
        }

        return res.toString();
    }
}
