import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static List<String> missingWords(String s, String t) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();

        String[] splitByS = s.split(" ");
        String[] spiltByT = t.split(" ");

        int start = 0;

        int i = 0;

        for (; i < splitByS.length; i++) {
            if (!splitByS[i].equals(spiltByT[start])) {
                res.add(splitByS[i]);
            } else {
                start += 1;
                break;
            }
        }

        for (int j = i + 1; j < splitByS.length; j++) {
            if (splitByS[j].equals(spiltByT[start])) {
                start++;
                if (start == spiltByT.length) {
                    for (int k = j + 1; k < splitByS.length; k++) {
                        res.add(splitByS[k]);
                    }
                }
            } else {
                res.add(splitByS[i]);
            }
        }



        return res;
    }
}
