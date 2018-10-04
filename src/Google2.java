import java.util.Arrays;

public class Google2 {
    public int[] solution(int[] stores, int[] houses) {
        // write your code in Java SE 8
        int[] res = new int[houses.length];

        Arrays.sort(stores);

        for (int i = 0; i < res.length; i++) {
            res[i] = binarySearch(stores, houses[i]);
        }
        return res;
    }

    private int binarySearch(int[] stores, int i) {
        int start = 0;
        int end = stores.length - 1;

        while (start  + 1 < end) {
            int middle = start + (end - start) / 2;
            if (stores[middle] == i) {
                return i;
            }
            if (stores[middle] < i) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (Math.abs(stores[start] - i) <= Math.abs(stores[end] - i)) {
            return stores[start];
        }
        return stores[end];
    }
}
