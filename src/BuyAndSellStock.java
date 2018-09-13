public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] memory = new int[prices.length];
        int max = prices[prices.length - 1];
        int maxIndex = prices.length - 1;
        int minIndex = maxIndex;
        int min = max;
        int profit = 0;

        for (int i = prices.length - 2; i >= 0 ; i--) {
            if (prices[i] < min) {
                minIndex = i;
                min = prices[i];
                if (minIndex < maxIndex && profit < prices[maxIndex] - prices[minIndex]) {
                    profit = prices[maxIndex] - prices[minIndex];
                }
            }

            if (prices[i] > max) {
                if (minIndex < maxIndex && profit < prices[maxIndex] - prices[minIndex]) {
                    profit = prices[maxIndex] - prices[minIndex];
                }
                max = prices[i];
                maxIndex = i;
                minIndex = i;
                min = prices[i];
            }
        }
       return profit;
    }
}
