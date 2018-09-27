import java.util.ArrayList;

public class MaxSubstring {
    static String compute(String s) {
        ArrayList<Integer> max = new ArrayList<>();
        char maxChar = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > maxChar) {
                max.clear();
                max.add(i);
                maxChar = s.charAt(i);
            } else if (s.charAt(i) == maxChar) {
                max.add(i);
            }
        }
        int offset = 1;

        while (max.size() != 1) {
            char ch = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < max.size(); i++) {
                int index = max.get(i) + offset;
                if (index >= s.length()) {
                    continue;
                } else if (s.charAt(index) == ch) {
                    temp.add(max.get(i));
                } else if (s.charAt(index) > ch) {
                    temp.clear();
                    ch = s.charAt(index);
                    temp.add(max.get(i));
                }
            }
            offset++;
            max = temp;
        }

        return s.substring(max.remove(0));
    }

    public static void main(String[] args) {
        System.out.println(MaxSubstring.compute("aaa"));
        System.out.println(MaxSubstring.compute("aba"));
        System.out.println(MaxSubstring.compute("cbbbcddd"));
        System.out.println(MaxSubstring.compute("caacbbbbc"));
    }
}
