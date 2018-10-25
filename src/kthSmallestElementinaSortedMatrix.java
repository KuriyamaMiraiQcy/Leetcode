import java.util.PriorityQueue;

public class kthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }

        int num = 0;
        while (k != 0) {
            num = pq.poll();
            while (pq.peek() == num) {
                pq.poll();
            }
            k--;
        }
        return num;
    }
    //faster solution
    public int KthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}
