package Uber;

import java.util.HashMap;
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

    //Faster
    public int LengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
