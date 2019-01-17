import java.util.ArrayDeque;
import java.util.Stack;

public class SwapAdjacentinLRString {
    public boolean canTransform(String start, String end) {
        if (start.indexOf('X') == -1 || end.indexOf('X') == -1) {
            return start.equals(end);
        }

        ArrayDeque<Integer> rQueue = new ArrayDeque<>();
        ArrayDeque<Integer> lQueue = new ArrayDeque<>();

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                rQueue.add(i);
            }
            if (start.charAt(i) == 'L') {
                lQueue.add(i);
            }
        }

        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == 'R') {
                if (rQueue.isEmpty()) {
                    return false;
                }
                int index = rQueue.poll();
                if (index > i) {
                    return false;
                }
            }
            if (end.charAt(i) == 'L') {
                if (lQueue.isEmpty()) {
                    return false;
                }
                int index = lQueue.poll();
                if (index < i) {
                    return false;
                }
            }
        }
        return rQueue.isEmpty() && lQueue.isEmpty();
    }

    //one pass solution
    public boolean CanTransform(String start, String end) {
        int i = 0, j = 0, m = start.length(), n = end.length();
        if(m!=n) return false;
        while(i<m && j<n) { // This misses the corner case as mentioned and fixed by @crazyzzy
            while(i<m && start.charAt(i)=='X') i++;
            while(j<n && end.charAt(j)=='X') j++;
            if(i==m || j == n) {
                return j==i;
            }
            if((start.charAt(i)=='L' && end.charAt(j)=='L' && i>=j) ||
                    (start.charAt(i)=='R' && end.charAt(j)=='R' && i<=j)) {
                i++;
                j++;
            }
            else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        SwapAdjacentinLRString a = new SwapAdjacentinLRString();
        System.out.println(a.canTransform("XXXXXLXXXX","LXXXXXXXXX"));
    }
}
