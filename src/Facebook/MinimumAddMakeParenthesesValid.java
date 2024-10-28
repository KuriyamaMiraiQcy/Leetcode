package Facebook;

public class MinimumAddMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int count = 0, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count < 0) {
                    sum -= count;
                    count = 0;
                }
                ++count;
            } else {
                count--;
            }
        }
        sum += Math.abs(count);
        return sum;
    }
}
