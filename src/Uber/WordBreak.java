package Uber;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        int[] memory = new int[s.length()];

        for (int i = s.length() -1; i >= 0; i--) {
            if (wordDict.contains(s.substring(i))) {
                memory[i] = 1;
            } else {
                for (int j = i + 1; j < s.length(); j++) {
                    if (memory[j] != 0 && wordDict.contains(s.substring(i, j))) {
                        memory[i] = memory[j] + 1;
                    }
                }
            }
        }

        return memory[0] != 0;
    }
}
