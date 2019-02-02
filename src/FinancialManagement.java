import java.util.Scanner;

public class FinancialManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder count = new StringBuilder("00.0");

        for (int i = 0; i < 12; i++) {
            StringBuilder line = new StringBuilder(input.nextLine());
            line = line.reverse();

            int carry = 0;
            int j = 0;

            for (; j < line.length(); j++) {
                if (j == 2) {
                    continue;
                }

                int add = Character.getNumericValue(line.charAt(j));

                if (j < count.length()) {
                    int origin = Character.getNumericValue(count.charAt(j));

                    count.setCharAt(j, (char)('0' + (origin + add + carry) % 10));
                    carry = (origin + add + carry) / 10;
                } else {
                    count.append((char) ('0' + (carry + add) % 10));

                    carry = (carry + add) / 10;
                }
            }

            while (carry == 1) {
                if (count.length() == line.length()) {
                    count.append(carry);
                } else {
                    int origin = Character.getNumericValue(count.charAt(j));

                    count.setCharAt(j, (char) ('0' + (origin + carry) % 10));

                    carry = (carry + origin) / 10;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        int cur = 0;

        for (int i = count.length() - 1; i >= 0; i--) {
            if (i == 2) {
                result.append('.');
                continue;
            }

            int num = cur * 10 + Character.getNumericValue(count.charAt(i));

            result.append(num / 12);
            cur = num % 12;

        }

        String res = result.toString();

        while (res.charAt(0) == '0') {
            res = res.substring(1);
        }
        System.out.println("$" + res);
    }
}
