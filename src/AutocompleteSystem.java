import sun.text.normalizer.Trie;

import java.util.*;

public class AutocompleteSystem {
    static TrieNode root;
    HashMap<String, String> map;
    HashMap<String, Integer> count;
    TrieNode searchRoot;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        count = new HashMap<>();
        searchRoot = root;
        prefix = new String();

        for (int i = 0; i < sentences.length; i++) {
            count.put(sentences[i], times[i]);
            addSentence(sentences[i], 0, root);
        }
    }

    public List<String> input(char c) {
        ArrayList<String> res = new ArrayList<>();
        int index;
        if (c == ' ') {
            index = 26;
        } else {
            index = c - 'a';
        }
        if (c == '#') {
            searchRoot.isEnd = true;
            if (!count.containsKey(prefix)) {
                count.put(prefix, 0);
            }
            count.put(prefix, count.get(prefix + 1));
            prefix = new String();
            searchRoot = root;
            return res;
        }
        prefix += c;
        if (searchRoot.next[index] != null) {

            searchRoot = searchRoot.next[index];
            searchForSentence(searchRoot, res, new String(prefix));

            Collections.sort(res, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int hit1 = count.get(o1);
                    int hit2 = count.get(o2);

                    if (hit1 == hit2) {
                        return o1.compareTo(o2);
                    }
                    return hit2 - hit1;
                }
            });
        } else {
            searchRoot.next[index] = new TrieNode(c);
        }

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (!res.isEmpty()) {
                result.add(res.remove(0));
            } else {
                break;
            }
        }
        return result;
    }

    private void searchForSentence(TrieNode root, ArrayList res, String prefix) {
        if (root.isEnd) {
            res.add(prefix);
        }

        for (int i = 0; i < 27; i++) {
            if (root.next[i] != null) {
                searchForSentence(root.next[i], res, new String(prefix + root.next[i].ch));
            }
        }
    }

    private void addSentence(String str, int index, TrieNode root) {
        if (index == str.length()) {
            return;
        }
        int i;
        char ch = str.charAt(index);
        if (ch == ' ') {
            i = 26;
        } else {
            i = ch - 'a';
        }
        if (root.next[i] == null) {
            root.next[i] = new TrieNode(ch);
        }
        if (index == str.length() - 1) {
            root.next[i].isEnd = true;
        }

        addSentence(str, index + 1, root.next[i]);
    }

    class TrieNode {
        char ch;
        boolean isEnd;
        TrieNode[] next = new TrieNode[27];

        TrieNode() {
            ch = 0;
            isEnd = false;
        }

        TrieNode(char ch) {
            this.ch = ch;
            isEnd = false;
        }

    }

    public static void main(String[] args) {
        AutocompleteSystem a = new AutocompleteSystem(new String[]{"i love you", "island", "iroman"}, new int[]{5,4,3});
    }
}
