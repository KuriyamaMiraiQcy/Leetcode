package Facebook;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return addStrings(num2, num1);
        }
        int n_1 = num1.length(), n_2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < n_2; i--) {
            int num_1 = n_1 - 1 - i >= 0 ? (num1.charAt(n_1 - 1 - i) - '0') : 0;
            int num_2 = num2.charAt(n_2 - 1 - i) - '0';
            int sum = num_1 + num_2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
