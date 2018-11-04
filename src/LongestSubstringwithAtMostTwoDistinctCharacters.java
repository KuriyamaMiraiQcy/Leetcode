import java.util.HashSet;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int max = 1;
        int start = 0;
        int end = 2;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        set.add(s.charAt(1));

        for (int i = 2; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                end++;
            } else if (!set.contains(ch) && set.size() != 2) {
                set.add(ch);
                end++;
            } else {
                max = Math.max(max, end - start);
                set.clear();
                set.add(ch);
                int j = end - 1;
                end++;
                for (; j >= 0; j--) {
                    if (s.charAt(j) != s.charAt(i)) {
                        set.add(s.charAt(j));
                    }
                    if (set.size() == 3) {
                        set.remove(s.charAt(j));
                        break;
                    }
                }
                start = j + 1;
            }
        }
        max = Math.max(max, end - start);
        return max;
    }

    // sliding windows solution
    public int LengthOfLongestSubstringTwoDistinct(String s) {
        if (s.isEmpty()) return 0;
        int max = 1;
        int p1 = 0, p2 = 0;//p1:last index of first char  p2:last index of second char
        int last = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (p1 != p2 && chars[i] != chars[p1] && chars[i] != chars[p2]) {
                if (last > max) max = last;

                last = i - p1;
                p1 = p2;
                p2 = i;
            } else {
                if (chars[i] == chars[p1]) {
                    p1 = p1 == p2 ? i : p2;
                }
                last++;
                p2 = i;
            }
        }

        if (last > max) max = last;
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters a = new LongestSubstringwithAtMostTwoDistinctCharacters();
        a.lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }
}
