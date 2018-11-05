package Uber;

public class BasicCalculator {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int sum = 0;
        int prevOperator = 1;
        int prevNum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int[] evalRes = eval(i, s);
                prevNum = evalRes[0];
                i = evalRes[1];
            } else if (isOperator(s.charAt(i))) {
                sum = operate(prevNum, prevOperator, sum);
                prevNum = 0;
                prevOperator = decideOperator(s.charAt(i));
            } else {
                prevNum = prevNum * 10 + Character.getNumericValue(s.charAt(i));
            }
        }

        sum = operate(prevNum, prevOperator, sum);
        return sum;
    }

    private int operate(int prevNum, int prevOperator, int sum) {
        if (prevOperator == 1) {
            return prevNum + sum;
        }
        return sum - prevNum;
    }

    private int decideOperator(char ch) {
        return (ch == '+')?1:0;
    }

    private int[] eval(int i, String s) {
        int sum = 0;
        int prevOperator = 1;
        int prevNum = 0;
        int j = i + 1;

        for (;j < s.length(); j++) {
            if (s.charAt(j) == ')') {
                break;
            }
            if (s.charAt(j) == '(') {
                int[] evalRes = eval(j, s);
                prevNum = evalRes[0];
                j = evalRes[1];
            } else if (isOperator(s.charAt(j))) {
                sum = operate(prevNum, prevOperator, sum);
                prevNum = 0;
                prevOperator = decideOperator(s.charAt(j));
            } else {
                prevNum = prevNum * 10 + Character.getNumericValue(s.charAt(j));
            }
        }
        sum = operate(prevNum, prevOperator, sum);
        int[] res = new int[2];
        res[0] = sum;
        res[1] = j;
        return res;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-';
    }
}
