package Facebook;

public class AddSearchWords {
    static class WordDictionary {
        class TrieNode {
            boolean isWord;
            char ch;

            TrieNode[] children = new TrieNode[26];

            TrieNode(char ch) {
                this.ch = ch;
            }
        }

        TrieNode root;
        public WordDictionary() {
            root = new TrieNode('\0');
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    cur.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            return search(word,0, root);
        }

        private boolean search(String word, int index, TrieNode cur) {
            if (index == word.length()) {
                return cur.isWord;
            }
            if (word.charAt(index) != '.') {
                return cur.children[word.charAt(index) - 'a'] != null && search(word, index + 1, cur.children[word.charAt(index) - 'a']);
            }

            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (search(word, index + 1, cur.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
