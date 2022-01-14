import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word:words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int result = 0;
        for (String word:words2) {
            if (map.containsKey(word) && map.get(word)<=1) {
                map.put(word, map.get(word) - 1);
            }
        }
        for (Map.Entry a:map.entrySet()) {
            if (a.getValue().equals(0)) {
                result++;
            }
        }
        return result;
    }
}
