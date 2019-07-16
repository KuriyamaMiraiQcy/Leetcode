package Facebook;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int oneEnd = m - 1;
        int twoEnd = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if (twoEnd < 0) {
                break;
            } else if (oneEnd < 0){
                nums1[i] = nums2[twoEnd];
                continue;
            }
            if (nums1[oneEnd] <= nums2[twoEnd]) {
                nums1[i] = nums2[twoEnd];
                twoEnd--;
            } else {
                if (oneEnd != i) {
                    nums1[i] = nums1[oneEnd];
                    nums1[oneEnd] = 0;
                    oneEnd--;
                }
            }
        }
    }
}
