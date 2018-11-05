package Uber;

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return min(nums, 0, nums.length - 1);
    }

    private int min(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                return Math.min(min(nums, start, mid), min(nums, mid + 1, end));
            }
            if (nums[start] <= nums[mid] && nums[mid] <= nums[end]) {
                end = mid;
            } else if (nums[start] >= nums[mid] && nums[mid] >= nums[end]) {
                start = mid + 1;
            } else if (nums[start] <= nums[mid] && nums[mid] >= nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
