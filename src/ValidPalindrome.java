public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (s.charAt(start) < 'A' || s.charAt(start) > 'Z' && s.charAt(start) < 'a' || s.charAt(start) > 'z') {
                start++;
            }
            while (s.charAt(end) < 'A' || s.charAt(end) > 'Z' && s.charAt(end) < 'a' || s.charAt(end) > 'z') {
                end--;
            }
            int num = Math.abs(s.charAt(start) - s.charAt(end));
            if (num != 0 && num != 32) {
                return false;
            }
        }
        return true;
    }
}
