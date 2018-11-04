package Uber;

public class SolvetheEquation {
    public String solveEquation(String equation) {
        String[] separateByEqual = equation.split("=");
        String left = separateByEqual[0];
        String right = separateByEqual[1];

        int[] leftVal = getValue(left);
        int[] rightVal = getValue(right);
        if (leftVal[0] == rightVal[0] && leftVal[1] == rightVal[1]) {
            return "Infinite solutions";
        }

        if (leftVal[0] == rightVal[0] && leftVal[1] != rightVal[1]) {
            return "No solution";
        }

        int x = leftVal[0] - rightVal[0];
        int constant = rightVal[1] - leftVal[1];

        return "x=" + Integer.toString(constant / x);

    }

    private int[] getValue(String s) {
        int start = 0;
        int countX = 0;
        int countConstant = 0;
        int prevOperator = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i == 0) {
                    prevOperator = -1;
                    continue;
                }
                if (s.charAt(i - 1) == 'x') {
                    String toParse = s.substring(start, i - 1);
                    int num = 1;
                    if (!toParse.equals("")) {
                        num = Integer.parseInt(toParse);
                    }

                    if (prevOperator == 0) {
                        countX += num;
                    } else {
                        countX -= num;
                    }
                } else {
                    String toParse = s.substring(start, i);
                    int num = Integer.parseInt(toParse);

                    if (prevOperator == 0) {
                        countConstant += num;
                    } else {
                        countConstant -= num;
                    }
                }

                if (s.charAt(i) == '+') {
                    prevOperator = 0;
                } else {
                    prevOperator = 1;
                }
                start = i + 1;
            }
        }

        if (s.charAt(s.length() - 1) == 'x') {
            String toParse = s.substring(start, s.length() - 1);
            int num = 1;
            if (!toParse.equals("")) {
                num = Integer.parseInt(toParse);
            }

            if (prevOperator == 0) {
                countX += num;
            } else {
                countX -= num;
            }
        } else {
            String toParse = s.substring(start);
            int num = Integer.parseInt(toParse);

            if (prevOperator == 0) {
                countConstant += num;
            } else {
                countConstant -= num;
            }
        }

        return new int[]{countX, countConstant};
    }
}
