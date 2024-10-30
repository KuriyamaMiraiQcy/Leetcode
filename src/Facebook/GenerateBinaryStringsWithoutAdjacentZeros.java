package Facebook;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros {
    List<String> result = new ArrayList<>();
    public List<String> validStrings(int n) {
        buildString(n,0, new StringBuilder());
        return result;
    }

    private void buildString(int n, int index, StringBuilder s) {
        if (s.length() == n) {
            result.add(s.toString());
            return;
        }
        if (s.isEmpty() || s.charAt(s.length() - 1) == '1') {
            s.append('0');
            buildString(n, index+1, s);
            s.deleteCharAt(s.length() - 1);
        }
        s.append('1');
        buildString(n, index + 1, s);
        s.deleteCharAt(s.length() - 1);
    }
}
