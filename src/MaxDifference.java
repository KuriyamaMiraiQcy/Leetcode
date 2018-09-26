public class MaxDifference {
    public int findDifference(int[] array) {
        int maxGap = -1;
        int prev = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < prev) {
                prev = array[i];
            } else if (array[i] - prev > maxGap) {
                maxGap = array[i] - prev;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        MaxDifference a = new MaxDifference();
        System.out.println(a.findDifference(new int[]{7,2,3,10,2,4,8,1}));
        System.out.println(a.findDifference(new int[]{6,7,9,5,6,3,2}));
    }
}
