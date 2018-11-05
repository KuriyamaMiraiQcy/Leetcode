package Uber;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
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
