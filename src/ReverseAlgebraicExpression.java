import java.util.LinkedList;
import java.util.Stack;

public class ReverseAlgebraicExpression {
    public String reverse(String input) {
        int start = 0;
        Stack<String> number = new Stack<>();
        Stack<String> operator = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (isOperator(temp)) {
                number.push(input.substring(start, i));
                operator.push(Character.toString(temp));
                start = i + 1;

                if (isNegative(input.charAt(i + 1))) {
                    i += 1;
                }
            }
        }
        number.push(input.substring(start, input.length()));

        String result = new String();

        while (number.size() != 1) {
            result += number.pop();
            result += operator.pop();
        }

        result += number.pop();
        return result;
    }

    private boolean isOperator(char a) {
        return a == '+' || a == '-' || a == '*' || a== '/';
    }

    private boolean isNegative(char a) {
        return a == '-';
    }

    public static void main(String[] args) {
        ReverseAlgebraicExpression a = new ReverseAlgebraicExpression();

        System.out.print(a.reverse("23.89+-9.6-2.4*1"));
    }
}
