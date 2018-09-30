import java.util.Random;

public class RandomPickwithWeight {
    int[] count;
    int sum = 0;
    public RandomPickwithWeight(int[] w) {
        count = new int[w.length + 1];

        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            count[i + 1] = sum;
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int a = rand.nextInt(sum) + 1;

        for (int i = 1; i < count.length; i++) {
            if (a > count[i - 1] && a < count[i]) {
                return i -1;
            }
        }

        return count.length - 2;
    }
}
