package Facebook;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) return isOneEditDistance(t, s);

        if (s.length() + 1 < t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            if (t.charAt(i) != s.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return s.length() == t.length() - 1;
    }
}
