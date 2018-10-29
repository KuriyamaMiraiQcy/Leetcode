import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int leftMore = 0;
        int rightMore = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftMore++;
            } else if (s.charAt(i) == ')') {
                if (leftMore > 0) {
                    leftMore--;
                } else {
                    rightMore++;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        HashSet<String> res = new HashSet<>();
        DFS(0, s, str, res, leftMore, rightMore, 0);
        ArrayList<String> finalRes = new ArrayList<>();
        for (String string:res) {
            finalRes.add(string);
        }
        return finalRes;
    }

    private void DFS(int index, String s, StringBuilder str, HashSet<String> res, int leftMore, int rightMore, int open) {
        if (index == s.length()) {
            if (leftMore == 0 && rightMore == 0 && open == 0) {
                res.add(str.toString());
            }
            return;
        }
        if (leftMore < 0 || rightMore < 0 || open < 0) {
            return;
        }
        int length = str.length();

        if (s.charAt(index) == '(') {
            DFS(index + 1, s, str, res, leftMore - 1, rightMore, open);
            DFS(index +1, s, str.append(s.charAt(index)), res, leftMore, rightMore, open +1);
        } else if (s.charAt(index) == ')') {
            DFS(index + 1, s, str, res, leftMore, rightMore - 1, open);
            DFS(index + 1, s, str.append(')'), res, leftMore, rightMore, open - 1);
        } else {
            DFS(index + 1, s, str.append(s.charAt(index)), res, leftMore, rightMore, open);
        }
        str.setLength(length);
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        a.removeInvalidParentheses("()())()");
    }
}
