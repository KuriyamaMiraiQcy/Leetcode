package Facebook;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (compare(nums, mid - 1, mid) > 0 && compare(nums, mid, mid + 1) < 0) {
                return mid;
            }
            if (compare(nums, mid - 1, mid) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int compare(int[] nums, int prev, int next) {
        if (prev == -1) {
            return 1;
        }
        if (next == nums.length) {
            return -1;
        }
        return nums[next] - nums[prev];
    }
}
