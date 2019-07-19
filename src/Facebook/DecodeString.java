package Facebook;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int sum = 0;
                while (Character.isDigit(s.charAt(i))) {
                    sum = 10 * sum + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                numStack.push(sum);
            } else if (ch == '[') {
                stack.push(result);
                result = "";
                i++;
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder (stack.pop());
                int repeatTimes = numStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(result);
                }
                result = temp.toString();
                i++;
            } else {
                result += s.charAt(i++);
            }
        }
        return result;
    }
}
