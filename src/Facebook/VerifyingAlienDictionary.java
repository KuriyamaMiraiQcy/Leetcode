package Facebook;

import java.util.HashMap;

public class VerifyingAlienDictionary {
    HashMap<Character, Integer> charMap = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            charMap.put(order.charAt(i), i);
        }
        charMap.put('0', -1);

        for (int i = 1; i < words.length; i++) {
            if (compareString(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compareString(String a, String b) {
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            char prev = a.length() > i ? a.charAt(i) : '0';
            char next = b.length() > i ? b.charAt(i) : '0';

            if (charMap.get(next) - charMap.get(prev) != 0) {
                return charMap.get(prev) - charMap.get(next);
            }
        }
        return 0;
    }
}
