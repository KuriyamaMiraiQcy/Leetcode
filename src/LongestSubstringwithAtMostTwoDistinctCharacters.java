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

    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters a = new LongestSubstringwithAtMostTwoDistinctCharacters();
        a.lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }
}
