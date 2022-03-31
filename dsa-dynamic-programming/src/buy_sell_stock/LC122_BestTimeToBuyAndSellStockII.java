package buy_sell_stock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @level : medium
 */
public class LC122_BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
        
        return maxProfit(prices, 0,1,new HashMap<>());
    }
    
    private int maxProfit(int[] prices, int currentDay, int canBuy, Map<String, Integer> memo){
        
        // day exit the last day
        if(currentDay == prices.length) return 0;
        
        // create string key with currentDay and canBuy
        String currentKey = currentDay+"#"+canBuy;
        if(memo.containsKey(currentKey)) return memo.get(currentKey);
        
        int profit = 0;
        if(canBuy == 1){
            // buy if enabled(canBuy==1) 
            int buy = maxProfit(prices, currentDay+1, canBuy-1, memo)-prices[currentDay];
            // stay idle
            int idle = maxProfit(prices, currentDay+1, canBuy, memo);
            profit = Math.max(buy, idle);
        }
        else{
            // sell if sell enabled(canBuy==0)
            int sell = maxProfit(prices, currentDay+1, canBuy+1, memo)+prices[currentDay];
            // stay idle
            int idle = maxProfit(prices, currentDay+1, canBuy, memo);
            profit = Math.max(sell, idle);
        }
        
        // memorize profit for current step
        memo.put(currentKey, profit);
        //return 
        return memo.get(currentKey);
    }
}
