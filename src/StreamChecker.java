public class StreamChecker {
    Trie root;
    String stream;
    class Trie {
        boolean isWord;
        Trie[] children;
        Trie() {
            children = new Trie[26];
        }
    }
    public StreamChecker(String[] words) {
        root = new Trie();
        stream = "";
        for (String word:words) {
            Trie parent = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (parent.children[word.charAt(i) - 'a'] == null) {
                    parent.children[word.charAt(i) - 'a'] = new Trie();
                }
                parent = parent.children[word.charAt(i) - 'a'];
            }
            parent.isWord = true;
        }
    }

    private boolean checkString(String str) {
        Trie parent = root;
        for (int i = 0; i < str.length(); i++) {
            if (parent.children[str.charAt(i) - 'a'] == null) {
                return false;
            }
            parent = parent.children[str.charAt(i) - 'a'];
            if (parent.isWord) {
                return true;
            }
        }
        return false;
    }

    public boolean query(char letter) {
        stream = letter + stream;
        return checkString(stream);
    }

    public static void main(String[] args) {
        StreamChecker a = new StreamChecker(new String[]{"cd", "f", "kl"});
        a.query('k');
        a.query('l');
    }
}
