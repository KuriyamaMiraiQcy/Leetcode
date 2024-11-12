package Facebook;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; ++i) {
                result[i] = nums[i] * nums[i];
            }
            return result;
        }

        int neg = 0;
        while (neg < nums.length && nums[neg] < 0) {
            neg++;
        }
        int pos = neg - 1, start = 0;
        while (pos >= 0 && neg < nums.length) {
            if (Math.abs(nums[pos]) < Math.abs(nums[neg])) {
                result[start++] = nums[pos] * nums[pos--];
            } else {
                result[start++] = nums[neg] * nums[neg++];;
            }
        }
        while (pos >= 0) {
            result[start++] = nums[pos] * nums[pos--];
        }
        while (neg < nums.length) {
            result[start++] = nums[neg] * nums[neg++];
        }
        return result;
    }
}
