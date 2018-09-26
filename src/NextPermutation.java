public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        if (nums.length == 2) {
            swap(nums, 0 ,1);
            return;
        }
        int i = nums.length - 1;
        for (; i > 1; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }

        if (i == 1 && nums[0] > nums[1]) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        if (i == nums.length - 1) {
            swap(nums, i -1, i);
            return;
        }

        if (nums[i - 1] >= nums[i + 1]) {
            swap(nums, i, i - 1);
            reverse(nums, i, nums.length - 1);
        } else {
            for (int j = nums.length - 1; j >i; j--) {
                if (nums[j] > nums[i - 1]) {
                    swap(nums, j, i - 1);
                    reverse(nums, i, nums.length - 1);
                    return;
                }
            }
        }
        return;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i , j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation a = new NextPermutation();
        a.nextPermutation(new int[]{3,2,1});
    }
}
