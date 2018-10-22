import java.util.HashMap;

public class RomanToInteger {
    private static HashMap<Character, Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s.length() == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int cur = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));
            if (cur < next) {
                sum -= cur;
            } else {
                sum += cur;
            }
        }
        return sum;
    }
}
