import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions.length == 0) {
            return res;
        }

        int[] intervals = new int[positions.length * 2];

        for (int i = 0; i < positions.length; i++) {
            intervals[2 * i] = positions[i][0];
            intervals[2 * i + 1] = positions[i][0] + positions[i][1];
        }

        Arrays.sort(intervals);

        int[] height = new int[intervals.length - 1];

        int maxHeight = 0;
        for (int i = 0; i < positions.length; i++) {
            int start = positions[i][0];
            int startIndex = Arrays.binarySearch(intervals, start);
            int curHeight = positions[i][1];
            int max = 0;
            for (int j = startIndex; intervals[j] < start + curHeight; j++) {
                max = Math.max(max, height[j]);
            }
            int newHeight = max + curHeight;
            for (int j = startIndex; intervals[j] < start + curHeight; j++) {
                height[j] = newHeight;
            }
            maxHeight = Math.max(newHeight, maxHeight);
            res.add(maxHeight);
        }
        return res;
    }
}
