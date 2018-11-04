package Uber;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        return possible(nums, sum / k, new int[k], nums.length - 1);
    }

    private boolean possible(int[] nums, int sum, int[] p, int idx) {
        //System.out.println(idx);
        if (idx == -1) {
            // for (int s : p) System.out.print(s + " ");
            //System.out.println();
            for (int s : p)  {
                if (s != sum) {
                    return false;
                }
            }
            return true;
        }

        int num = nums[idx];

        for (int i = 0; i < p.length; i++) {
            if (p[i] + num <= sum) {
                p[i] += num;
                if (possible(nums, sum, p, idx - 1)) {
                    return true;
                }
                p[i] -= num;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitiontoKEqualSumSubsets a = new PartitiontoKEqualSumSubsets();
        a.canPartitionKSubsets(new int[]{4,4,6,2,3,8,10,2,10,7}, 4);
    }
}
