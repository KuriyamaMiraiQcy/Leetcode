package Uber;
import java.util.*;

public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    static String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static String matchMost1(String[] nums, HashSet<String> words){
        String maxDigits = "";
        int maxCount = 0;
        for(int i=0;i<nums.length;i++) {
            String digits = nums[i];
            List<String> match = digitsToWord(digits);
            int count = 0;
            for (String m : match) {
                if (words.contains(m)) {
                    count++;
                }
            }
            if(count>maxCount){
                maxCount = count;
                maxDigits = digits;
            }
        }
        return maxDigits;
    }

    //words is small
    public static String matchMost2(String[] nums, String[] words){
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<String, Integer> countmap = new HashMap<>();
        for(int i=0;i<letter.length;i++){
            String s = letter[i];
            if(!s.equals("")){
                for(char c: s.toCharArray()){
                    map.put(c,i);
                }
            }
        }

        for(int i=0;i<words.length;i++){
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()){
                sb.append(map.get(c));
            }
            countmap.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }

        int max = 0;
        String maxDig = "";
        for(String digit: countmap.keySet()){
            int count = map.get(digit);
            if(count>max){
                max = count;
                maxDig = digit;
            }
        }
        return maxDig;
    }

    public static List<String> digitsToWord(String digits){
        List<String> res = new ArrayList<>();
        dfs(res, "", digits, 0);
        return res;
    }

    private static void dfs(List<String> res, String one, String digits, int start){
        if(start==digits.length()){
            res.add(one);
            return;
        }
        String words = letter[digits.charAt(start)-'0'];
        if(words.length()==0){
            dfs(res,one,digits,start+1);
        }
        for(char c: words.toCharArray()){
            dfs(res, one+c, digits, start+1);
        }
    }
}
