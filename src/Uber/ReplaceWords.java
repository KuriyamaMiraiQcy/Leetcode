package Uber;

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode('0');
        for (String s:dict) {
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (temp.next[ch - 'a'] == null) {
                    temp.next[ch - 'a'] = new TrieNode(ch);
                }
                temp = temp.next[ch - 'a'];
            }
            temp.isEnd = true;
        }

        StringBuilder res = new StringBuilder();

        TrieNode temp = root;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) >= 'a' && temp.next[sentence.charAt(i) - 'a'] != null) {
                temp = temp.next[sentence.charAt(i) - 'a'];
                res.append(sentence.charAt(i));
                if (temp.isEnd) {
                    while (i < sentence.length() && sentence.charAt(i) != ' ') {
                        i++;
                    }
                    res.append(' ');
                    temp = root;
                }
            } else {
                while (i < sentence.length() && sentence.charAt(i) != ' ') {
                    res.append(sentence.charAt(i));
                    i++;
                }
                res.append(' ');
                temp = root;
            }
        }


        return res.toString().trim();
    }

    class TrieNode {
        char ch;
        boolean isEnd;
        TrieNode[] next = new TrieNode[26];

        TrieNode() {
            ch = 0;
            isEnd = false;
        }

        TrieNode(char ch) {
            this.ch = ch;
            isEnd = false;
        }
    }
}
