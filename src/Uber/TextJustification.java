import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        int count = 0;
        int num = 0;

        for (int i = 0; i < words.length; i++) {
            if (count + words[i].length() >= maxWidth) {
                int offset = 1;
                if (count + words[i].length() == maxWidth) {
                    offset = 0;
                    num += 1;
                    count += words[i].length();
                }
                int left = maxWidth - count + offset;
                list.add(generateString(words, start, num - 1, left));
                start += num;
                if (offset == 0) {
                    count = 0;
                    num = 0;
                } else {
                    count = words[i].length() + 1;
                    num = 1;
                }
            } else {
                count += words[i].length() + 1;
                num++;
            }
        }

        String leftJustification = new String();
        for (int i = start; i < words.length; i++) {
            leftJustification += words[i] + " ";
        }
        if (leftJustification.length() != 0) {
            leftJustification = leftJustification.substring(0, leftJustification.length() - 1);
            if (leftJustification.length() < maxWidth) {
                int length = maxWidth - leftJustification.length();
                for (int i = 0; i < length; i++) {
                    leftJustification += " ";
                }
            }
            list.add(leftJustification);
        }
        return list;
    }

    private String generateString(String[] words, int start, int num, int left) {
        if (num == 0) {
            String s = words[start];
            for (int i = 0; i < left; i++) {
                s += " ";
            }
            return s;
        }
        int n = num;
        double avg = 1;
        avg += Math.ceil((double) left / (double) n);
        String str = new String();

        for (int i = 0; i < num; i++) {
            str += words[start + i];
            for (int j = 0; j < avg; j++) {
                str += " ";
            }
            n--;
            left -= Math.max(0, avg - 1);
            avg = 1 + Math.ceil((double) left / (double) n);
        }
        str += words[start + num];
        return str;
    }

    //simple and faster solution
    public List<String> FullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }


        return lines;
    }

    public static void main(String[] args) {
        TextJustification a = new TextJustification();
        a.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
    }
}
