import java.util.*;

public class KClosestPointstoOrigin {
    private double distance(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }

    public int[][] KClosest(int[][] points, int K) {
        Comparator<Integer> comparator = (a, b) -> distance(points[a]) != distance(points[b]) ? Double.compare(distance(points[a]), distance(points[b])) : a - b;
        PriorityQueue<Integer> kCloset = new PriorityQueue<>(comparator);

        for (int i = 0; i < points.length; i++) {
            kCloset.add(i);
        }

        int[][] result = new int[K][];

        for (int i = 0; i < K; i++) {
            result[i] = points[kCloset.poll()];
        }

        return result;
    }

    // Succint Solution
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
}
