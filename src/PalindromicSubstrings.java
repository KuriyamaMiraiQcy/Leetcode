public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += findPalindrome(i, i, s);
            sum += findPalindrome(i, i + 1, s);
        }
        return sum;
    }

    private int findPalindrome(int left, int right, String s) {
        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
            return 0;
        }
        return 1 + findPalindrome(left - 1, right + 1, s);
    }
}
