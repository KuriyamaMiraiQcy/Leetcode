package Uber;

import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> lst = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (isOpen(s.charAt(i))) {
                lst.add(s.charAt(i));
            } else {
                if (lst.size() == 0) {
                    return false;
                }
                char ch = lst.remove();
                if (ch == '(' && s.charAt(i) != ')') {
                    return false;
                }
                if (ch == '{' && s.charAt(i) != '}') {
                    return false;
                }
                if (ch == '[' && s.charAt(i) != ']') {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch =='[';
    }


}
