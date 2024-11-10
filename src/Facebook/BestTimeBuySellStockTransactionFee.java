package Facebook;

public class BestTimeBuySellStockTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int new_buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = new_buy;
        }
        return sell;
    }
}
