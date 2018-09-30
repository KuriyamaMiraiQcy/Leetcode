import java.util.HashMap;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int value = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), value + 1);
        }

        int odd = 0;
        for (Character ch:map.keySet()) {
            if (map.get(ch) % 2 == 1) {
                odd++;
                if (odd > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
