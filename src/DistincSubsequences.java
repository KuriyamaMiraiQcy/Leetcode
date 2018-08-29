import java.util.LinkedList;

public class DistincSubsequences {
    private int numHelper(LinkedList<Character> s, LinkedList<Character> t) {
        if (t.size() > s.size() || s.size() == 0 || t.size() == 0) {
            return 0;
        }
        if (s.size() == 1 && t.size() == 1) {
            if (s.poll() == t.poll()) {
                return 1;
            }
            return 0;
        }

        char ch = t.poll();

        while (s.size() != 0) {
            char a = s.poll();
            if (a ==ch) {
                break;
            }
        }

        return numHelper(s, t);
    }

    public int numDistinct(String s, String t) {
        LinkedList<Character> longString = new LinkedList<>();
        LinkedList<Character> target = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            longString.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            longString.add(t.charAt(i));
        }

        return numHelper(longString, target);
    }
}
