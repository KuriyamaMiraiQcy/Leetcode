package Facebook;

public class RemoveDuplicatesSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int index = 0, count = 1, start = 0;
        while (start + count< nums.length) {
            if (nums[start + count] != nums[start + count - 1]) {
                for (int i = 0; i < Math.min(2, count); i++) {
                    nums[index++] = nums[start];
                }
                start = start + count;
                count = 1;
            } else {
                count++;
            }
        }
        for (int i = 0; i < Math.min(2, count); i++) {
            nums[index++] = nums[start];
        }
        return index;
    }
}
