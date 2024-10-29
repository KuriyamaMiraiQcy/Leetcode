package Facebook;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return result;
    }

    private void dfs(String s, int i, List<String> sep) {
        if (i == s.length()) {
            result.add(new ArrayList<>(sep));
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (isPalindrome(s, i, j - 1)) {
                sep.add(s.substring(i, j));
                dfs(s, j, sep);
                sep.remove(sep.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
