import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s:tokens) {
            if (isOperator(s)) {
                int next = stack.pop();
                int first = stack.pop();

                if (s.equals("+")) {
                    stack.push(next + first);
                } else if (s.equals("-")) {
                    stack.push(first - next);
                } else if (s.equals("*")) {
                    stack.push(first * next);
                } else {
                    if (next != 0) {
                        stack.push(first / next);
                    } else {
                        stack.push(0);
                    }
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
