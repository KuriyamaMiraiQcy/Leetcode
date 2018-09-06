import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        HashSet<Character> list = new HashSet<>();


        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            } else {
                maxLength = Math.max(list.size(), maxLength);
                i = start;
                start += 1;
                list.clear();

            }
        }
        if (maxLength == 0) {
            return s.length();
        }
        return Math.max(list.size(), maxLength);
    }
}
