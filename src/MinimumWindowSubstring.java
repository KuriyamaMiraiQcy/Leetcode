import java.util.ArrayDeque;
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

    public static void main(String[] args) {
        MinimumWindowSubstring a = new MinimumWindowSubstring();
        a.minWindow("ADOBECODEBANC", "ABC");
    }
}
