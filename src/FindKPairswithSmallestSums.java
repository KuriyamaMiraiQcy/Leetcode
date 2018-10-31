import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return res;
        }

        boolean combination = k > nums1.length * nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (combination) {
                    res.add(new int[]{nums1[i], nums2[j]});
                } else {
                    pq.offer(new int[]{nums1[i], nums2[j]});
                }
            }
        }

        if (!combination) {
            for (int i = 0; i < k; i++) {
                if (!pq.isEmpty()) {
                    res.add(pq.poll());
                }
            }
        }
        return res;
    }
}
