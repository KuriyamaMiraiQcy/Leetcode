package Facebook;

import java.util.HashMap;

public class ApplyDiscountEveryNOrders {
    class Cashier {
        int count = 0, threshold;
        double discount;
        HashMap<Integer, Integer> map;
        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.discount = 100.0 - discount;
            this.threshold = n;
            map = new HashMap<>();
            for (int i = 0; i < products.length; i++) {
                map.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            ++count;
            double sum = 0;
            for (int i = 0; i < product.length; i++) {
                sum += map.get(product[i]) * amount[i];
            }
            if (count % threshold == 0) {
                sum *= discount / 100;
            }
            return sum;
        }
    }
}
