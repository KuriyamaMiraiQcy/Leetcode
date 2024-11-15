package Facebook;

import java.util.Arrays;
import java.util.HashSet;

public class GroupsSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            int[] count = new int[52];
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(Arrays.toString(count));
        }
        return set.size();
    }
}
