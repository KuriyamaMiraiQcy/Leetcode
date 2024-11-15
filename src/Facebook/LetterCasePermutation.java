package Facebook;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> result;
    public List<String> letterCasePermutation(String s) {
        StringBuilder builder = new StringBuilder();
        result = new ArrayList<>();
        permutation(s, 0, builder);
        return result;
    }

    private void permutation(String s, int i, StringBuilder builder) {
        if (i == s.length()) {
            result.add(builder.toString());
            return;
        }
        char c = s.charAt(i);
        if (Character.isLetter(c)) {
            builder.append(Character.toLowerCase(c));
            permutation(s, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append(Character.toUpperCase(c));
            permutation(s, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append(c);
            permutation(s, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
