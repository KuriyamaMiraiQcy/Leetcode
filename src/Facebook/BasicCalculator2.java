package Facebook;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        int num = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
                continue;
            }
            switch (operator) {
                case '*': {
                    stack.push(stack.pop() * num);
                    num = 0;
                    break;
                }
                case '/': {
                    stack.push(stack.pop() / num);
                    num = 0;
                    break;
                }
                default: {
                    num = operator == '+' ? num : -num;
                    stack.push(stack.pop() + num);
                    break;
                }
            }
            if (i < s.length()) {
                operator = s.charAt(i);
            }
        }
        return stack.pop();
    }
}
