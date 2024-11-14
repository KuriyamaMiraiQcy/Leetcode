package Facebook;

public class StringIntegerAtoi {
    public int myAtoi(String s) {
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        int start = 0;
        if (s.isEmpty()) return 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            ++start;
        }
        if (start == s.length() || (s.charAt(start) != '-' && s.charAt(start) != '+' && !Character.isDigit(s.charAt(start)))) {
            return 0;
        }
        boolean positive = s.charAt(start) != '-';
        if (!Character.isDigit(s.charAt(start))) {
            ++start;
        }
        int i = start;
        if (start >= s.length()) {
            return 0;
        }
        boolean leadingZero = s.charAt(i) == '0';
        for (; i < s.length() && Character.isDigit(s.charAt(i));++i) {
            if (leadingZero && s.charAt(i) == '0') {
                ++start;
            } else {
                leadingZero = false;
            }
        };
        String digits = s.substring(start, i);
        if (digits.isEmpty()) {
            return 0;
        }
        if (positive) {
            if (digits.length() > 10 || (digits.length() == 10 && digits.compareTo(Integer.toString(max)) > 0)) {
                return Integer.MAX_VALUE;
            }
            return Integer.parseInt(digits);
        }
        digits = "-" + digits;
        if (digits.length() > 11 || (digits.length() == 11 && digits.compareTo(Integer.toString(min)) > 0)) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(digits);
    }
}
