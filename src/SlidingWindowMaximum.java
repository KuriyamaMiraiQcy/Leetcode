import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (queue.size() != 0 && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == queue.peek()) {
                queue.pop();
            }
            while (queue.size() != 0 && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.add(nums[i]);
            res[i - k + 1] = queue.peek();
        }
        return res;
    }
}
