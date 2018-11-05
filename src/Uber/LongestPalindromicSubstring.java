package Uber;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        int[][] memory = new int[length + 1][length + 1];

        for (int i = 0; i < length -1; i++) {
            memory[i][i] = 1;
            if (s.charAt(i) == s.charAt(i + 1)) {
                memory[i][i + 1] = 2;
                max = 2;
                start = i;
                end = i + 1;
            }
        }
        if (max != 2) {
            max = 1;
        }
        memory[length - 1][length - 1] = 1;

        for (int i = length -1; i >= 0; i--) {
            for (int j = i + 2; j < length ; j++) {
                if (s.charAt(i) == s.charAt(j) && memory[i + 1][j - 1] != 0) {
                    memory[i][j] = memory[i + 1][j - 1] + 2;
                    if (memory[i][j] > max) {
                        max = memory[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.print(test.longestPalindrome("aaaabaaa"));
    }
}
