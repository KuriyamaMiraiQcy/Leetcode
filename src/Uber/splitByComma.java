package Uber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SplitByComma {
    public List<String> splitByComma(String s) {
        List<String> res = new LinkedList<>();
        String curString = "";
        boolean isClosed = true;

        for (int i = 0; i < s.length(); i++) {
            if (!isClosed) {
                if (s.charAt(i) == '"') {
                    isClosed = true;
                    curString += s.charAt(i);
                    res.add(curString);
                    curString = "";
                } else {
                    curString += s.charAt(i);
                }
            } else {
                if (s.charAt(i) == '"') {
                    res.add(curString);
                    isClosed = false;
                    curString = "\"";
                } else if (s.charAt(i) == ' ' || s.charAt(i) == ',') {
                    res.add(curString);
                    curString = "";
                } else {
                    curString += s.charAt(i);
                }
            }
        }

        if (isClosed) {
            res.add(curString);
        } else {
            res.addAll(Arrays.asList(curString.split(",")));
        }

        return res;
    }

    public static void main(String[] args) {
        SplitByComma a = new SplitByComma();
        for (String s:a.splitByComma("aaa,kkk\"dsds\"aaa\"dssds,ffdf,d")) {
            System.out.println(s);
        }
    }
}
