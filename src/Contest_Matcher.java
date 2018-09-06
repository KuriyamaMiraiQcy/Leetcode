import java.util.Arrays;
import java.util.stream.IntStream;

public class Contest_Matcher {
    private String match(String[] pair) {
        if (pair.length == 1) {
            String str = Arrays.toString(pair);
            return str.substring(1, str.length() - 1);
        }

        int length = pair.length;
        String[] newPair = new String[length / 2];

        for (int i = 0; i < length / 2; i += 1) {
            String combine = "(" + pair[i] + "," + pair[length - 1- i] + ")";
            newPair[i] = combine;
        }

        return match(newPair);
    }

    public String findContestMatch(int n) {
        String[] pair = new String[n];
        for (int i = 0; i < n; i++) {
            pair[i] = Integer.toString(i + 1);
        }

        return match(pair);
    }
}
