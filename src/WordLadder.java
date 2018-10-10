import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String s:wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }

        queue.add(beginWord);
        queue.add("");
        int level = 1;

        while (!queue.isEmpty()) {
            String head = queue.pop();
            if (!head.isEmpty()) {
                char[] charArray = head.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char current = charArray[i];
                    for (int j = 0; j < 26; j++) {
                        if ('a' + j != current) {
                            charArray[i] =(char)('a' + j);
                            String change = new String(charArray);
                            if (change.equals(endWord)) {
                                return level + 1;
                            }
                            if (set.contains(change)) {
                                visited.add(change);
                                set.remove(change);
                                queue.add(change);
                            }
                        }
                    }
                    charArray[i] = current;
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add("");
                }
                level++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder a = new WordLadder();
        LinkedList<String> list = new LinkedList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        a.ladderLength("hit", "cog", list);
    }
}
