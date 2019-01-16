import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuesstheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = Arrays.asList(wordlist);

        for (int i = 0; i < 10; ++i) {
            String guess = pick(words);

            int match = master.guess(guess);
            List<String> sameMatches = new ArrayList<>();

            for (String word:words) {
                if (match(word, guess) == match && !word.equals(guess)) {
                    sameMatches.add(word);
                }
            }

            words = sameMatches;
        }
    }

    private String pick(List<String> words) {
        int min = Integer.MAX_VALUE;
        String bestPick = "";

        for (String s: words) {
            int max = calculateHistogramDistance(s, words);
            if (max < min) {
                min = max;
                bestPick = s;
            }
        }

        return bestPick;
    }

    private int calculateHistogramDistance(String s, List<String> words) {
        int[] distanceCount = new int[s.length() + 1];
        for (String str:words) {
            distanceCount[match(s, str)]++;
        }

        int max = 0;
        for (int n:distanceCount) {
            max = Math.max(max, n);
        }

        return max;
    }

    private int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i) if (a.charAt(i) == b.charAt(i)) matches ++;
        return matches;
    }
}
