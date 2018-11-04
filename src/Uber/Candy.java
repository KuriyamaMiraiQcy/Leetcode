package Uber;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] order = new int[ratings.length];
        Arrays.fill(order, 1);

        for (int i = 1; i < order.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                order[i] = order[i - 1] + 1;
            }
        }

        for (int i = order.length - 1; i > 0 ; i--) {
            if (ratings[i - 1] > ratings[i]) {
                order[i - 1] = Math.max(order[i] + 1, order[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < order.length; i++) {
            sum += order[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy a = new Candy();
        a.candy(new int[]{1,2,2});
    }
}
