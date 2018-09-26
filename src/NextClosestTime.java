import java.util.Arrays;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        String[] arr = time.split(":");
        int[] nums = new int[4];

        nums[0] = Character.getNumericValue(arr[0].charAt(0));
        nums[1] = Character.getNumericValue(arr[0].charAt(1));
        nums[2] = Character.getNumericValue(arr[1].charAt(0));
        nums[3] = Character.getNumericValue(arr[1].charAt(1));

        int[] cloned = nums.clone();
        Arrays.sort(cloned);

        if (nums[3] == cloned[3]) {
            nums[3] = cloned[0];
        } else {
            for (int i = 0; i < 4; i++) {
                if (cloned[i] > nums[3]) {
                    nums[3] = cloned[i];
                    return createString(nums);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (cloned[i] < 6 && cloned[i] > nums[2]) {
                nums[2] = cloned[i];
                return createString(nums);
            }
        }
        nums[2] = cloned[0];

        if (nums[0] == 2) {
            for (int i = 0; i < 4; i++) {
                if (cloned[i] < 4 && cloned[i] > nums[1]) {
                    nums[1] = cloned[i];
                    return createString(nums);
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (cloned[i] > nums[1]) {
                    nums[1] = cloned[i];
                    return createString(nums);
                }
            }
        }
        nums[1] = cloned[0];

        for (int i = 0; i < 4; i++) {
            if (cloned[i] < 3 && cloned[i] > nums[0]) {
                nums[0] = cloned[i];
                return createString(nums);
            }
        }
        nums[0] = cloned[0];
        return createString(nums);
    }

    private String createString(int[] nums) {
        String res = new String();
        for (int n = 0; n < nums.length; n++) {
            res += Integer.toString(nums[n]);
            if (n == 1) {
                res += ":";
            }
        }

        return res;
    }
}
