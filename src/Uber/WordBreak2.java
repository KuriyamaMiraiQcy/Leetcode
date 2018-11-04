package Uber;

import java.util.*;

public class WordBreak2 {
    //memory exceed for dp
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<Stack<String>> memory[] = new LinkedList[s.length()];

        for (int i = s.length() - 1; i >= 0 ; i--) {
            LinkedList<Stack<String>> list = new LinkedList<>();
            memory[i] = list;

            if (wordDict.contains(s.substring(i))) {
                Stack<String> temp = new Stack<>();
                temp.push(s.substring(i));
                list.add(temp);
            } else {
                for (int j = i; j <= s.length(); j++) {
                    if (wordDict.contains(s.substring(i, j))) {
                        if (memory[j].isEmpty()) {
                            Stack<String> stack = new Stack<>();
                            stack.push(s.substring(i, j));
                            list.add(stack);
                        } else {
                            for (Stack<String> stack : memory[j]) {
                                Stack<String> stackClone = (Stack<String>) stack.clone();
                                stackClone.push(s.substring(i, j));
                                list.add(stackClone);
                            }
                        }
                    }
                }
            }
        }

        ArrayList<String> result = new ArrayList<>();

        for (Stack<String> stack:memory[0]) {
            String combination = new String();
            while (!stack.empty()) {
                combination += stack.pop() + " ";
            }
            combination = combination.substring(0,combination.length() -1);
            result.add(combination);
        }

        return result;
    }
    //DFS with memorization
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
