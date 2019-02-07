import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWord = new HashSet<>();

        for (String word:banned) {
            bannedWord.add(word);
        }

        String[] words = paragraph.split(" ");
        HashMap<String, Integer> count = new HashMap<>();

        for (String word:words) {
            word = word.replaceAll("\\W", "").toLowerCase();
            if (!bannedWord.contains(word)) {
                count.put(word.toLowerCase(), count.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }

        String frequent = "";
        int frequency = 0;

        for (String key:count.keySet()) {
            if (count.get(key) > frequency) {
                frequent = key;
                frequency = count.get(key);
            }
        }

        return frequent;
    }
}
