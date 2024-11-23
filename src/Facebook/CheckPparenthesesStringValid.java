package Facebook;

import java.util.Stack;

public class CheckPparenthesesStringValid {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        Stack<Integer> left = new Stack<>();
        Stack<Integer> free = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                free.push(i);
                continue;
            }
            if (s.charAt(i) == '(') {
                left.push(i);
            } else {
                if (!left.empty()) {
                    left.pop();
                } else {
                    if (free.empty()) {
                        return false;
                    }
                    free.pop();
                }
            }
        }
        while (!left.empty()) {
            int index = left.pop();
            if (free.isEmpty() || free.peek() < index) {
                return false;
            }
            free.pop();
        }
        return free.size() % 2 == 0;
    }
}
