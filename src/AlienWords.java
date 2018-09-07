import java.util.*;

public class AlienWords {
    public String alienOrder(String[] words) {
        HashMap<Character, Graph> map = new HashMap<>();

        for (int j = 0; j < words.length; j += 1) {
            String str = words[j];
            char ch = str.charAt(0);

            Graph startCharacter;
            if (!map.containsKey(ch)) {
                startCharacter = new Graph(ch);
                startCharacter.isParent = true;
                map.put(ch, startCharacter);
            } else {
                if (str.length() == 1 && j != 0 && !words[j].equals(words[j - 1])) {
                    return "";
                }
                startCharacter = map.get(ch);
            }

            for (int i = 1; i < str.length(); i++) {
                Graph next;

                if (!map.containsKey(str.charAt(i))) {
                    next = new Graph(str.charAt(i));
                    map.put(str.charAt(i), next);
                } else {
                    next = map.get(str.charAt(i));

                }

                if (!startCharacter.isNeighbor(next)) {
                    startCharacter.addNeighbor(next);
                }
                startCharacter = next;
            }
        }


        List<Character> list = new LinkedList<>();
        for (Character ch:map.keySet()) {
            if (map.get(ch).isParent) {
                ((LinkedList<Character>) list).addLast(ch);
            }
        }



        String result = "";
        int[] visited = new int[26];
        while (list.size()!= 0) {
            char a = ((LinkedList<Character>) list).removeLast();
            if (visited[a - 'a'] == 0) {
                result += a;
                visited[a - 'a'] = 1;
                if (map.get(a).neibohors.size() != 0) {
                    for (Graph g : map.get(a).neibohors) {
                        ((LinkedList<Character>) list).addFirst(g.ch);
                    }
                }
            }
        }

        return result;
    }

    public class Graph{
        char ch;
        LinkedList<Graph> neibohors;
        boolean isParent = false;

        public Graph(char ch) {
            this.ch = ch;
            neibohors = new LinkedList<>();
        }

        public boolean isNeighbor(Graph g) {
            return neibohors.contains(g);
        }

        public void addNeighbor(Graph g) {
            this.neibohors.add(g);
        }
    }

    public static void main(String[] args) {
        AlienWords test = new AlienWords();
        test.alienOrder(new String[]{"aac","aabb","aaba"});
    }
}
