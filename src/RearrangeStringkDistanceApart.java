import java.util.*;

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        HashMap<Character, HashMap<Character, Integer>> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                HashMap<Character, Integer> temp = count.get(s.charAt(i));
                temp.put(s.charAt(i), temp.get(s.charAt(i)) + 1);
            } else {
                HashMap<Character, Integer> temp = new HashMap<>();
                temp.put(s.charAt(i), 1);
                count.put(s.charAt(i), temp);
            }
        }

        LinkedList<HashMap<Character, Integer>> list = new LinkedList<>();

        for (Character ch:count.keySet()) {
            list.add(count.get(ch));
        }

        Collections.sort(list, new Comparator<HashMap<Character, Integer>>() {
            @Override
            public int compare(HashMap<Character, Integer> o1, HashMap<Character, Integer> o2) {
                return getHashMapValue(o1) - getHashMapValue(o2);
            }
        });

        int max = getHashMapValue(list.get(list.size() - 1));
        LinkedList<Character> same = new LinkedList<>();
        StringBuilder res = new StringBuilder(s);
        int start = 0;

        for (int i = list.size() - 2; i >= 0; i--) {
            HashMap<Character, Integer> o1 = list.get(i);
            if (getHashMapValue(o1) == max) {
                for (Character ch:o1.keySet()) {
                    same.add(ch);
                }
            } else {
                for (int j = 0; j < 1; j++) {

                }
            }
        }
        return "";
    }

    private int getHashMapValue(HashMap<Character, Integer> o1) {
        int num1 = 0;
        for (Character ch:o1.keySet()) {
            num1 = o1.get(ch);
        }
        return num1;
    }
}
