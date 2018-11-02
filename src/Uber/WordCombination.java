package Uber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordCombination {
    public List<String> words(String s) {
        String[] words = s.split(" ");
        HashMap<String, GraphNode> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new GraphNode(words[i]));
            }
            if (!map.containsKey(words[i + 1])) {
                map.put(words[i + 1], new GraphNode(words[i + 1]));
            }
            if (!map.get(words[i]).neighbours.contains(map.get(words[i + 1]))) {
                map.get(words[i]).neighbours.add(map.get(words[i + 1]));
            }
        }

        List<String> res = new LinkedList<>();
        for (GraphNode n : map.values()) {
            DFS(n, words.length, 0, res, "");
        }

        return res;
    }

    private void DFS(GraphNode cur, int length, int curLength, List<String> res, String curString) {
        curString += cur.s + " ";
        if (curLength == length - 1) {
            res.add(curString.trim());
            return;
        }

        for (GraphNode neighbour : cur.neighbours) {
            DFS(neighbour, length, curLength + 1, res, curString);
        }
    }

    class GraphNode {
        String s;
        LinkedList<GraphNode> neighbours;

        GraphNode(String s) {
            this.s = s;
            neighbours = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        WordCombination a = new WordCombination();
        for (String s : a.words("apple b apple")) {
            System.out.println(s);
        }
    }
}
