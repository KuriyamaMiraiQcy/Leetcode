import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 1) {
            res.add(s);
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int oddNum = 0;
        char oddIndex = 0;

        for (Character ch:map.keySet()) {
            if (map.get(ch) % 2 == 1) {
                oddNum++;
                oddIndex = ch;
            }
            map.put(ch, map.get(ch) / 2);
        }
        if (oddNum > 1) {
            return res;
        }

        StringBuilder str = new StringBuilder(s);
        if (oddNum == 1) {
            str.setCharAt(s.length() / 2, oddIndex);
        }

        setPalindrome(0, ((double)s.length() - 1) / 2, map, str, res);

        return res;
    }

    void setPalindrome(double start, double middle, HashMap<Character, Integer> map, StringBuilder str, ArrayList<String> res) {
        if (start + 0.4 > middle) {
            res.add(str.toString());
            return;
        }

        for (Character ch:map.keySet()) {
            int n = map.get(ch);
            if (n > 0) {
                str.setCharAt((int)start, ch);
                str.setCharAt((int)(middle + (middle - start)), ch);
                map.put(ch, n - 1);
                setPalindrome(start + 1, middle, map, str, res);
                map.put(ch, n);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePermutationII a = new PalindromePermutationII();
        System.out.println(a.generatePalindromes("aabba"));
    }
}
