package Facebook;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder(num1.length() + num2.length());
        for (int i = 0; i < result.capacity(); i++) {
            result.append('0');
        }
        for (int i = 0; i < num2.length() ; i++) {
            for (int j = 0; j < num1.length(); j++) {
                int val1 = num1.charAt(num1.length() - 1 - j) - '0', val2 = num2.charAt(num2.length() - 1 - i) - '0';
                int product = val1 * val2;
                int index = i + j;
                int curr = result.charAt(i + j) - '0';
                int sum = product + curr;
                while (sum > 9) {
                    curr = sum % 10;
                    sum /= 10;
                    result.setCharAt(index, (char) ('0' + curr));
                    index++;
                    curr = result.charAt(index) - '0';
                    sum += curr;
                }
                result.setCharAt(index, (char) ('0' +  sum));
            }
        }
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.reverse().toString();
    }
}
