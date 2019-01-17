import java.util.Arrays;
import java.util.HashMap;

public class FindAndReplaceinString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }

        Arrays.sort(indexes);

        for (int i = 0; i < indexes.length; i++) {
            sb.append(S.substring(start, indexes[i]));
            boolean isMatch = true;
            for (int j = 0; j < sources[map.get(indexes[i])].length(); j++) {
                if (S.charAt(indexes[i] + j) != sources[map.get(indexes[i])].charAt(j)) {
                    start = indexes[i];
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                sb.append(targets[map.get(indexes[i])]);
                start = indexes[i] + sources[map.get(indexes[i])].length();
            }
        }
        sb.append(S.substring(start, S.length()));
        return sb.toString();
    }

    //a bit optimization to avoid sort
    public String FindReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for (int i=0; i<indexes.length; i++) {
            // if a match is found in the original string, record it
            if (S.startsWith(sources[i], indexes[i])) {
                table.put(indexes[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<S.length(); ) {
            if (table.containsKey(i)) {
                // if a replacement was recorded before
                sb.append(targets[table.get(i)]);
                i+=sources[table.get(i)].length();
            } else {
                // if no replacement happened at this index
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
