package Uber;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String result ="";
        if(s==null || t == null){
            return result;
        }
        Map<Character, Integer> charToCount = new HashMap();
        for(char c : t.toCharArray()){
            charToCount.put(c, charToCount.getOrDefault(c,0)+1);
        }

        int start = 0;
        int counter = t.length();
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(charToCount.containsKey(ch)){
                int prevC = charToCount.get(ch);
                if(prevC>0)
                    counter--;
                charToCount.put(ch, prevC-1);
            }
            if(counter==0){
                start= doShrinkWindow(charToCount, s,start, i);
                String candidate = s.substring(start,i+1);
                result = result==null || result.length()==0 ||result.length()>candidate.length() ? candidate : result;
            }

        }

        return result;

    }
    private int doShrinkWindow(Map<Character,Integer> temp, String str, int start, int end){
        while(start<end){
            char ch = str.charAt(start);
            if(temp.containsKey(ch)){
                if(temp.get(ch)<0){
                    temp.put(ch, temp.get(ch)+1);
                } else
                    return start;
            }
            start++;
        }
        return start;

    }
    //real sliding windows solution
    public String MinWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int m = s.length(), n = t.length();
        int minLen = m + 1, left = 0;
        int lo = 0, cnt = 0;
        for (int hi = 0; hi < m; hi++) {
            char c = s.charAt(hi);
            map[c]--;
            if (map[c] >= 0) cnt++;
            while (cnt == n) {
                if (minLen > hi - lo + 1) {
                    minLen = hi - lo + 1;
                    left = lo;
                }
                char pre = s.charAt(lo);
                map[pre]++;
                if (map[pre] > 0) cnt--;
                lo++;
            }
        }
        return minLen == m + 1 ? "" : s.substring(left, left + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring a = new MinimumWindowSubstring();
        a.minWindow("ADOBECODEBANC", "ABC");
    }
}
