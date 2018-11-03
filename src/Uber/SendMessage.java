package Uber;

import java.util.ArrayList;
import java.util.List;

public class SendMessage {
    public List<String> splitMessage(String s, int limit) {
        String[] words = s.split(" +");
        int messageCount = 0;
        List<StringBuilder> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder(words[0]);
        int wordLength = words[0].length();

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > limit - 6) {
                return new ArrayList<>();
            }
            if (wordLength + 1 + words[i].length() + 6 > limit) {
                res.add(cur);
                cur = new StringBuilder(words[i]);
                wordLength = words[i].length();
                messageCount++;
            } else {
                cur.append(" " + words[i]);
                wordLength += 1 + words[i].length();
            }
        }

        messageCount++;
        res.add(cur);
        if (messageCount < 10) {
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                res.get(i).append(" (" + Character.forDigit(i + 1, 10) + "/" + Character.forDigit(messageCount, 10) + ")");
                result.add(res.get(i).toString());
            }
            return result;
        } else {
            messageCount = 0;
            res = new ArrayList<>();
            cur = new StringBuilder(words[0]);
            wordLength = words[0].length();

            for (int i = 1; i < words.length; i++) {
                if (words[i].length() > limit - 7) {
                    return new ArrayList<>();
                }
                if (wordLength + 1 + words[i].length() + 7 > limit) {
                    res.add(cur);
                    cur = new StringBuilder(words[i]);
                    wordLength = words[i].length();
                    messageCount++;
                } else {
                    cur.append(" " + words[i]);
                    wordLength += 1 + words[i].length();
                }
            }

            messageCount++;
            res.add(cur);
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                res.get(i).append(" (" + String.valueOf(i + 1) + "/" + String.valueOf(messageCount) + ")");
                result.add(res.get(i).toString());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SendMessage a = new SendMessage();
        for (String s: a.splitMessage("aaa fff fff sss a s d f few ggg  gg ds s bv", 10)) {
            System.out.println(s);
        }
    }
}
