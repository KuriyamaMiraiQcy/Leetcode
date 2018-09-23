import java.util.HashMap;
import java.util.LinkedList;

public class WholeMintueDilemma {
    public int countPair(int[] minute) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer n:minute) {
            int mod = n % 60;
            if (map.keySet().contains(mod)) {
                map.put(mod, map.get(mod) + 1);
            } else {
                map.put(mod, 1);
            }
        }

        int count = 0;

        for (Integer n:map.keySet()) {
            int num = map.get(n);
            if (n == 0 || n == 30) {
                count += num * (num -1);
            } else {
                count += num * map.get(60 - n);
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {
        WholeMintueDilemma a = new WholeMintueDilemma();
        System.out.print(a.countPair(new int[]{40, 20, 60, 100, 50, 70}));
    }
}
