public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() < b .length()) {
            return addBinary(b, a);
        }
        StringBuilder stringBuilder = new StringBuilder();

        int carry = 0;

        for (int i = 1; i <= a.length(); i++) {
            int sum = 0;
            if (i > b.length()) {
                sum = a.charAt(a.length() - i) - '0' + carry;
            } else {
                sum = a.charAt(a.length() - i) - '0' + b.charAt(b.length() - i) - '0' + carry;
            }
            if (sum < 2) {
                carry = 0;
            } else {
                carry = 1;
            }

            stringBuilder.append(sum % 2);
        }
        if (carry == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("1010", "1011"));
    }
}
