import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordLadder {
    HashMap<String, Integer> visited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        visited = new HashMap<>();
        for (String s:wordList) {
            set.add(s);
            visited.put(s, -1);
        }
        if (!set.contains(endWord)) {
            return 0;
        }

        return DFS(beginWord, endWord, set, 1);
    }

    private int DFS(String beginWord, String endWord, HashSet<String> set, int length) {
        if (set.size() == 0) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return length;
        }
        length++;
        set.remove(beginWord);
        int min = Integer.MAX_VALUE;

        for (String s:set) {
            if (calculateDistance(beginWord, s) == 1) {
                if (visited.get(s) != -1) {
                    min = (visited.get(s) == 0)?min:visited.get(s);
                } else {
                    int res = DFS(s, endWord, (HashSet<String>) set.clone(), length);
                    if (res != 0) {
                        min = Math.min(min, res);
                    }
                    visited.put(s, res);
                }
            }
        }
        set.add(beginWord);

        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    private int calculateDistance(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
