package Uber;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            int direct = decide(nums, target, start, end, mid);
            if (direct == 0) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int decide(int[] nums, int target, int start, int end, int mid) {
        if (target >= nums[start] && target < nums[mid]) {
            return 0;
        }
        if (target > nums[mid] && target <= nums[end]) {
            return 1;
        }
        if (nums[start] > nums[mid] && !(target < nums[start] && target>nums[mid])) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray a = new SearchinRotatedSortedArray();
        System.out.println(a.search(new int[]{5,1,2,3,4}, 1));
    }
}
