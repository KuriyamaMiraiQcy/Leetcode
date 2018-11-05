package Uber;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            return p.equals("*");
        }
        boolean[][] memory = new boolean[s.length() + 1][p.length() + 1];

        memory[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                memory[0][i] = memory[0][i - 1];
            }
        }


        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    memory[i + 1][j + 1] = memory[i][j];
                }
                if (p.charAt(j) == '*') {
                    memory[i + 1][j + 1] = memory[i][j] || memory[i + 1][j] || memory[i][j + 1];
                }
            }
        }

        return memory[s.length()][p.length()];
    }
}
