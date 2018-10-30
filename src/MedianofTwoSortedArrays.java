public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int length = (nums1.length + nums2.length + 1) / 2;

        int start = 0;
        int end = nums1.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int other = length - mid;
            if (nums2[other - 1] > nums1[mid]) {
                start = mid + 1;
            } else if (nums1[mid - 1] > nums2[other]){
                end = mid - 1;
            } else {
                int maxLeft = 0;
                if (start == 0) {
                    maxLeft = nums2[other - 1];
                } else if (other == 0) {
                    maxLeft = nums1[mid - 1];
                } else {
                    maxLeft = Math.max(nums2[other - 1], nums1[mid - 1]);
                }
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (mid == nums1.length) {
                    minRight = nums2[other];
                } else if (other == nums2.length) {
                    minRight = nums1[mid];
                } else {
                    minRight = Math.min(nums2[other], nums1[mid]);
                }
                return (maxLeft + minRight) / 2.0;
            }

        }
        return 0.0;
    }

    private int lessOrEqual(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays a = new MedianofTwoSortedArrays();
        System.out.println(a.findMedianSortedArrays(new int[]{1,2,5}, new int[]{3,4}));
    }
}
