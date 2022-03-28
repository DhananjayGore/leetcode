/**
 * 
 */
package buy.sell.stock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @level : medium
 */
public class LC309_BestTimeToBuyAndSellStockaWithCooldown {

	 Map<String, Integer> memo = new HashMap<>();
	    
	    public int maxProfit(int[] prices) {
	        
	        return maxProfit(prices, 0, 1);
	    }
	    
	    private int maxProfit(int[] prices,int presentDay,int canBuy){
	        
	        if(presentDay >= prices.length) return 0;
	        
	        String key = "pd"+presentDay+"cb"+canBuy;
	        if(memo.containsKey(key)) return memo.get(key);
	        
	        int profit=0;
	        if(canBuy == 1){
	            // two choices 1.buy  2.idle
	            int buy = maxProfit(prices, presentDay+1, 0)-prices[presentDay];
	            int idle = maxProfit(prices, presentDay+1, canBuy);
	            profit = Math.max(buy, idle);
	        }
	        else{
	            // two choices 1.sell 2.idle
	            //in sell call we are doing presenrtDay+2 as we can buy on very next day of sell day
	            int sell = maxProfit(prices, presentDay+2, 1)+prices[presentDay];
	            int idle = maxProfit(prices, presentDay+1, canBuy);
	            profit = Math.max(sell, idle);
	        }
	        memo.put(key, profit);
	        return memo.get(key);
	    }
}
