import java.util.HashSet;

public class Jewels {
    public int numJewelsInStones(String J, String S) {
        HashSet jewels = new HashSet<Character>();

        for (int i = 0; i < J.length(); i += 1) {
            jewels.add(J.charAt(i));
        }

        int count = 0;

        for (int j = 0; j < S.length(); j += 1) {
            if (jewels.contains(S.charAt(j))) {
                count += 1;
            }
        }

        return count;
    }
}
