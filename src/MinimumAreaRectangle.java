import java.util.*;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, HashSet<Integer>> map = partition(points);
        int min = Integer.MAX_VALUE;

        for (int[] left:points) {
            for (int[] right:points) {
                if (left[0] == right[0] || left[1] == right[1]) {
                    continue;
                }
                if (map.get(left[0]).contains(right[1]) && map.get(right[0]).contains(left[1])) {
                    min = Math.min(min, Math.abs(left[0] - right[0]) * Math.abs(left[1] - right[1]));
                }
            }
        }

        return min == Integer.MAX_VALUE?0:min;

    }

    private Map<Integer, HashSet<Integer>> partition(int[][] points) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] coordinate:points) {
            if (!map.containsKey(coordinate[0])) {
                HashSet<Integer> set = new HashSet<>();
                set.add(coordinate[1]);
                map.put(coordinate[0], set);
            } else {
                map.get(coordinate[0]).add(coordinate[1]);
            }
        }

        return map;
    }
}
