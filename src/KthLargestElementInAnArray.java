public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }
    private int partition(int[] nums, int start, int end, int k) {
        if (start == end) return nums[k];

        int left = start, right = end, pivot = nums[(left + right)/2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) left++;
            while (left <= right && nums[right] > pivot) right--;
            if (left <= right) swap(nums, left++, right--);
        }
        return (k < left) ? partition(nums, start, left - 1, k) : partition(nums, left, end, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
