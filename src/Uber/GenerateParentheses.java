package Uber;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> res = new LinkedList<>();

        generate(res, 0, 0, n,new String());
        return res;
    }

    private void generate(LinkedList<String> res, int openUsed, int closeUsed, int n, String cur) {
        if (openUsed == n && closeUsed == n) {
            res.add(cur);
            return;
        }
        if(openUsed < n)
            generate(res, openUsed+1, closeUsed, n, cur+"(");
        if(closeUsed < openUsed)
            generate(res, openUsed, closeUsed+1, n, cur+")");
    }
}
