package Facebook;

public class CountandSay {
    public String countAndSay(int n) {
        StringBuilder stringBuilder = new StringBuilder("1");

        for (int i = 0; i < n - 1; i++) {
            StringBuilder newString = new StringBuilder();
            char start = stringBuilder.charAt(0);
            int count = 1;
            for (int j = 1; j < stringBuilder.length(); j++) {
                if (stringBuilder.charAt(j) == start) {
                    count++;
                } else {
                    newString = newString.append(count);
                    newString = newString.append(start);
                    start = stringBuilder.charAt(j);
                    count = 1;
                }
            }
            stringBuilder = newString;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountandSay().countAndSay(7));

    }
}
