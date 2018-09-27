public class ReverseIInteger {
    public int reverse(int x) {
        StringBuilder s = new StringBuilder(Integer.toString(x));
        int i = 0;
        if (s.charAt(0) == '-') {
            i = 1;
        }

        int j = s.length() - 1;

        while (s.charAt(j) == '0') {
            j--;
            s.deleteCharAt(j + 1);
        }

        while (i < j) {
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);
            i++;
            j--;
        }

        try {
            return Integer.parseInt(s.toString());
        } catch (Exception o) {
            return 0;
        }
    }
}
