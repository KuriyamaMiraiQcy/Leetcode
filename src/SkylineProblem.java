import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SkylineProblem {
    //nlogn solution with segmenttree
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings.length == 0) {
            return res;
        }
        int[] intervals = new int[buildings.length * 2];
        int start = 0;

        for (int[] triple:buildings) {
            intervals[start++] = triple[0];
            intervals[start++] = triple[1];
        }

        Arrays.sort(intervals);

        SegmentTreeNode[] trees = new SegmentTreeNode[intervals.length - 1];

        for (int i = 0; i < intervals.length - 1; i++) {
            trees[i] = new SegmentTreeNode(intervals[i], intervals[i + 1], 0);
        }


        for (int[] triple:buildings) {
            int startIndex = binarySearch(triple[0], intervals);
            for (int i = startIndex; i < trees.length; i++) {
                if (trees[i].right > triple[1]) {
                    break;
                }
                trees[i].height = Math.max(trees[i].height, triple[2]);
            }
        }


        for (int i = 0; i < trees.length; i++) {
            res.add(new int[]{trees[i].left, trees[i].height});
            while (i < trees.length - 1 && trees[i + 1].height == trees[i].height) {
                i++;
            }
        }
        res.add(new int[]{trees[trees.length - 1].right, 0});
        return res;
    }

    private int binarySearch(int val, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    //divide and conquer
    public List<int[]> GetSkyline(int[][] buildings) {
        return merge(buildings, 0, buildings.length-1);
    }

    private LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> res = new LinkedList<>();
        if(lo > hi) {
            return res;
        } else if(lo == hi) {
            res.add(new int[]{buildings[lo][0], buildings[lo][2]});
            res.add(new int[]{buildings[lo][1], 0});
            return res;
        }
        int mid = lo+(hi-lo)/2;
        LinkedList<int[]> left = merge(buildings, lo, mid);
        LinkedList<int[]> right = merge(buildings, mid+1, hi);
        int leftH = 0, rightH = 0;
        while(!left.isEmpty() || !right.isEmpty()) {
            long x1 = left.isEmpty()? Long.MAX_VALUE: left.peekFirst()[0];
            long x2 = right.isEmpty()? Long.MAX_VALUE: right.peekFirst()[0];
            int x = 0;
            if(x1 < x2) {
                int[] temp = left.pollFirst();
                x = temp[0];
                leftH = temp[1];
            } else if(x1 > x2) {
                int[] temp = right.pollFirst();
                x = temp[0];
                rightH = temp[1];
            } else {
                x = left.peekFirst()[0];
                leftH = left.pollFirst()[1];
                rightH = right.pollFirst()[1];
            }
            int h = Math.max(leftH, rightH);
            if(res.isEmpty() || h != res.peekLast()[1]) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }
}
