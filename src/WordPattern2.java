import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        if (str.length() == 0 && pattern.length() == 0) {
            return true;
        }

        if (str.length() == 0 || pattern.length() == 0 || pattern.length() > str.length()) {
            return false;
        }

        return matchPattern(map, pattern, str, 0);
    }

    private boolean matchPattern(HashMap<Character, String> map, String pattern, String str, int index) {
        if (index == pattern.length() - 1) {
            char ch = pattern.charAt(index);
            if (map.containsKey(ch)) {
                return map.get(ch).equals(str);
            }
            if (map.containsValue(str) || str.isEmpty()) {
                return false;
            }
            return true;
        }

        char ch = pattern.charAt(index);
        if (map.containsKey(ch)) {
            String s = map.get(ch);
            if (s.length() > str.length()) {
                return false;
            }
            if (str.substring(0, s.length()).equals(s)) {
                return matchPattern((HashMap<Character, String>)map.clone(), pattern, str.substring(map.get(ch).length()), index + 1);
            }
            return false;
        } else {
            for (int i = 1; i <= str.length(); i++) {
                if (map.containsValue(str.substring(0, i))) {
                    continue;
                }
                map.put(ch, str.substring(0, i));
                if (matchPattern((HashMap<Character, String>)map.clone(), pattern, str.substring(i), index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    //solution
    public boolean WordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(str, 0, pattern, 0, map, set);
    }

    //solution
    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, i)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);

            if (set.contains(p)) {
                continue;
            }

            // create or update it
            map.put(c, p);
            set.add(p);

            // continue to match the rest
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }

            // backtracking
            map.remove(c);
            set.remove(p);
        }

        // we've tried our best but still no luck
        return false;
    }

    public static void main(String[] args) {
        WordPattern2 a = new WordPattern2();
        System.out.println(a.wordPatternMatch("itwasthebestoftimes", "ittwaastthhebesttoofttimes"));
    }
}