public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int open = 0;
        int count = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                    count++;
                    if (open == 0) {
                        max = Math.max(max, count * 2);
                        count = 0;
                    }
                }
            }
        }
        return Math.max(max, count * 2);
    }
}
