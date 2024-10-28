package Facebook;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int start = 0;
        int num = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (Character.isDigit(abbr.charAt(i))) {
                if (num == 0 && abbr.charAt(i) == '0') {
                    return false;
                }
                num = num * 10 + abbr.charAt(i) - '0';
            } else {
                start += num;
                if (start >= word.length() || abbr.charAt(i) != word.charAt(start)) {
                    return false;
                }
                ++start;
                num = 0;
            }
        }
        return start + num== word.length();
    }
}
