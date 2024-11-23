package Facebook;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                minCount++;
                maxCount++;
            } else if (s.charAt(i) == ')') {
                maxCount--;
                minCount = Math.max(0, minCount - 1);
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(0, minCount - 1);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}
