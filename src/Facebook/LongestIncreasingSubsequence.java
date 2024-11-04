package Facebook;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] insert = new int[nums.length];
        int end = 0;
        insert[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > insert[end]) {
                insert[++end] = nums[i];
            } else {
                int s = 0, e = end;
                while (s < e) {
                    int mid = (e + s) / 2;
                    if (insert[mid] < nums[i]) {
                        s = mid + 1;
                    } else {
                        e = mid;
                    }
                }
                insert[s] = nums[i];
            }
        }
        return end + 1;
    }
}
