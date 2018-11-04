package Uber;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        wordList.remove(endWord);
        LinkedList[] distanceToEnd = new LinkedList[wordList.size() + 1];
        for (int i = 0; i < distanceToEnd.length; i++) {
            LinkedList<Integer> list = new LinkedList();
            String compare;
            if (i == distanceToEnd.length - 1) {
                compare = beginWord;
            } else {
                compare = wordList.get(i);
            }
            for (int j = 0; j < wordList.size(); j++) {
                if (calculateDistance(wordList.get(j), endWord) <= calculateDistance(compare, endWord) && calculateDistance(compare, wordList.get(j)) == 1) {
                    list.add(j);
                }
            }
            distanceToEnd[i] = list;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<LinkedList<String>> result = new ArrayDeque<>();
        ArrayDeque<Integer> level = new ArrayDeque<>();
        queue.add(beginWord);
        level.add(1);
        LinkedList<String> start = new LinkedList<>();
        start.add(beginWord);
        result.add(start);

        while (queue.size() != 0) {
            String word = queue.poll();
            int depth = level.poll();
            LinkedList<String> resultTemp = result.poll();

            if (word.equals(endWord)) {
                res.add(resultTemp);
                while (level.peek() == depth) {
                    word = queue.poll();
                    level.poll();
                    resultTemp = result.poll();
                    if (word.equals(endWord)) {
                        res.add(resultTemp);
                    }
                }
                break;
            }
            int index = (word.equals(beginWord))?distanceToEnd.length - 1:wordList.indexOf(word);
            LinkedList<Integer> l = distanceToEnd[index];
            for (Integer n:l) {
                queue.push(wordList.get(n));
                level.push(depth + 1);
                LinkedList<String> clone = (LinkedList<String>) resultTemp.clone();
                clone.add(wordList.get(n));
                result.add(clone);
            }
        }
        return res;
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
