
public class DistincSubsequences {

    public int numDistinct(String s, String t) {
        if (t.length() == 1) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(0)) {
                    count++;
                }
            }
            return count;
        }
        int[][] memory = new int[t.length()][s.length()];
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == t.charAt(t.length() - 1)) {
                memory[t.length() - 1][j] = 1;
            }
        }

        for (int i = t.length() - 2; i >= 0; i--) {
            int count = 0;
            int max = 0;
            for (int j = s.length() - 2; j >= 0; j--) {
                count += memory[i][j + 1];
                max = Math.max(max, memory[i + 1][j + 1]);
                if (s.charAt(j) == t.charAt(i)) {
                    memory[i][j] = count + max;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = Math.max(res, memory[0][i]);
        }

        return res;
    }

    public static void main(String[] args) {
        DistincSubsequences a = new DistincSubsequences();
        a.numDistinct("babgbag", "bag");
    }
}
