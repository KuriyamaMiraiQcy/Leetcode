public class RotateArray {
    //inplace and o1 space solution
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length < k) {
            rotate(nums, k % nums.length);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (i == nums.length) {
                break;
            }
            int start = i + k;
            while (start < nums.length) {
                swap(nums, start, i);
                start += k;
            }
        }
        firstK(nums, k);
    }

    private void firstK(int[] nums, int k) {
        int start = nums.length % k;
        for (int i = start - 1; i >= 0 ; i--) {
            int cur = i;
            for (int j = 0; j < k - start; j++) {
                swap(nums, cur, cur + 1);
                cur++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        RotateArray a = new RotateArray();
        a.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
