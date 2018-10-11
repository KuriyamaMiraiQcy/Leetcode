public class RegularExpression {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return false;
        }
        int match = -1;
        int i = 0;
        for (; i < p.length() - 1; i++) {
            if (match == s.length() - 1) {
                break;
            }
            if (p.charAt(i + 1) != '*') {
                if (p.charAt(i) == '.') {
                    match++;
                } else {
                    if (p.charAt(i) != s.charAt(match + 1)) {
                        return false;
                    } else {
                        match++;
                    }
                }
            } else {
                if (p.charAt(i) == '.') {
                    if (i + 1 != p.length() - 1) {
                        char endChar = p.charAt(i + 2);
                        int j = match + 1;
                        for (; j < s.length(); j++) {
                            if (s.charAt(j) == endChar) {
                                break;
                            }
                        }
                        match = j - 1;
                        i = i + 1;
                    } else {
                        return true;
                    }
                } else {
                    int j = match + 1;
                    for (; j < s.length(); j++) {
                        if (s.charAt(j) != p.charAt(i)) {
                            break;
                        }
                    }
                    match = j - 1;
                    i++;
                }
            }
        }
        if (i < p.length() - 1) {
            return false;
        }
        if (match == s.length() - 1 && i > p.length() - 1) {
            return true;
        }
        if (match < s.length() - 1 && i > p.length() - 1) {
            return false;
        }
        if (match < s.length() - 2) {
            return false;
        }
        if (p.charAt(i) != '*') {
            if (match == s.length() - 1) {
                return false;
            }
            if (p.charAt(i) == '.') {
                return true;
            } else {
                return p.charAt(i) == s.charAt(match + 1);
            }
        }
        return match == s.length() - 1;
    }

    public static void main(String[] args) {
        RegularExpression a = new RegularExpression();
        a.isMatch("aaaa", "a*a");
    }
}
