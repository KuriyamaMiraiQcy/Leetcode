package Facebook;

public class PairSumClosestTarget {
    public int[] closestPairSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] result = new int[2];
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (Math.abs(sum - target) < Math.abs(result[0] + result[1] - target)) {
                result[0] = nums[start];
                result[1] = nums[end];
            }
            if (nums[start] + nums[end] < target) {
                ++start;
            } else {
                --end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PairSumClosestTarget pairSumClosestTarget = new PairSumClosestTarget();
        int[] nums = new int[]{10, 22, 28, 29, 30, 40};
        System.out.println(pairSumClosestTarget.closestPairSum(nums, 54)[0]);
        System.out.println(pairSumClosestTarget.closestPairSum(nums, 54)[1]);
        nums = new int[]{1, 3, 4, 7, 10};
        System.out.println(pairSumClosestTarget.closestPairSum(nums, 15)[0]);
        System.out.println(pairSumClosestTarget.closestPairSum(nums, 15)[1]);
    }
}
