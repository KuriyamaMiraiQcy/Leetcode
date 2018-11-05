package Uber;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickwithBlacklist {
    int M;
    Random r;
    Map<Integer, Integer> map;

    public RandomPickwithBlacklist(int N, int[] blacklist) {
        map = new HashMap();
        for (int b : blacklist) // O(B)
            map.put(b, -1);
        M = N - map.size();

        for (int b : blacklist) { // O(B)
            if (b < M) { // re-mapping
                while (map.containsKey(N - 1))
                    N--;
                map.put(b, N - 1);
                N--;
            }
        }

        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }

    public static void main(String[] args) {
        RandomPickwithBlacklist a = new RandomPickwithBlacklist(2, new int[0]);
        for (int i = 0; i < 10; i++) {
            System.out.println(a.pick());
        }
    }
}
