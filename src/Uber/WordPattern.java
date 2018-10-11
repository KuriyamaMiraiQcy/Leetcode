import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] handler = str.split(" ");
        if (pattern.length() != handler.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(pattern.charAt(i))) {
                if (!handler[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            }
            else {
                if(map.containsValue(handler[i]))
                    return false;
                map.put(pattern.charAt(i), handler[i]);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern a= new WordPattern();
        a.wordPattern("abba", "dog cat cat fish");
    }
}
