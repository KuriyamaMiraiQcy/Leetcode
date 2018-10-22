public class multiplyStrings {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        int flow = 0;
        for (int i = result.length; i >= 0; i--) {
            flow = (result[i] + flow) / 10;
            result[i] = (result[i] + flow) % 10;
        }
        StringBuilder str = new StringBuilder();
        int start = 0;
        while (start < result.length && result[start] == 0) {
            start++;
        }
        if (start == result.length) {
            return "0";
        }
        for (int i = start; i < result.length; i++) {
            str.append(result[i]);
        }
        return str.toString();
    }
}
