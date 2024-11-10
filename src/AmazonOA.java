import java.util.Arrays;

public class AmazonOA {
    int maxMoney(int[][] bags, int k) {
        int[] data = new int[bags[bags.length - 1][1]];
        for (int[] b : bags) {
            for (int i = b[0]; i <= b[1]; i++) {
                data[i - 1] = b[2];
            }
        }

        int end = k, sum = 0, result = 0;
        for (int i = 0; i < k; i++) {
            sum += data[i];
        }
        while (end < data.length) {
            sum += data[end] - data[end - k];
            end++;
            result = Math.max(result, sum);
        }
        return result;
    }

    int caloriesBurn(int[] height) {
        Arrays.sort(height);
        int sum = height[height.length - 1] * height[height.length - 1];
        int start = 0, end = height.length - 1, prev = height[height.length - 1];
        while (start < end) {
            sum += (height[end] - height[start]) * (height[end] - height[start]);
            if (prev == height[end]) {
                end--;
                prev = height[start];
            } else {
                start++;
                prev = height[end];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        AmazonOA a = new AmazonOA();
        System.out.println(a.maxMoney(new int[][]{{1,4,2}, {6,6,5}, {7,7,7},{9,10,1}}, 5));
        System.out.println(a.caloriesBurn(new int[]{5,2,5}));
    }
}
