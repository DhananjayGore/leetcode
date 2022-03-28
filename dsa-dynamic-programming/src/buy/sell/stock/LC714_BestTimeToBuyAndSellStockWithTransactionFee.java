/**
 * 
 */
package buy.sell.stock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @level : medium
 */
public class LC714_BestTimeToBuyAndSellStockWithTransactionFee {

	Map<String, Integer> dp = new HashMap<>();

	public int maxProfit(int[] prices, int fee) {

		return maxProfit(prices, 0, 1, fee);
	}

	private int maxProfit(int[] prices, int day, int isBuyEnabled, int fee) {

		if (day >= prices.length)
			return 0;

		String key = day + "_" + isBuyEnabled;
		if (dp.containsKey(key))
			return dp.get(key);

		int profit = 0;
		if (isBuyEnabled == 1) {
			// when isBuyEnabled == 1 we can either buy the stock on that day or stay idle
			int buy = maxProfit(prices, day + 1, 0, fee) - prices[day];
			int idle = maxProfit(prices, day + 1, isBuyEnabled, fee);
			profit = Math.max(buy, idle);
		} else {
			// when isBuyEnabled == 0 we have 2 option either we can sell stock on the day
			// with
			// Transaction Fee or idle for the day
			int sell = maxProfit(prices, day + 1, 1, fee) + (prices[day] - fee);
			int idle = maxProfit(prices, day + 1, isBuyEnabled, fee);
			profit = Math.max(sell, idle);
		}

		dp.put(key, profit);
		return dp.get(key);
	}
}
