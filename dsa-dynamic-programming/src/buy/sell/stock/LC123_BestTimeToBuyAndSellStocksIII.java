/**
 * 
 */
package buy.sell.stock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @level : hard
 */
public class LC123_BestTimeToBuyAndSellStocksIII {

	Map<String, Integer> memo = new HashMap<>();
    public int maxProfit(int[] prices) {
         return maxProfit(prices, 0, 1, 2);
    }
    
    private int maxProfit( int[] prices, int currentDay, int canBuy, int transCount)
    {
        //when days end or available transaction are empty
        if(currentDay >= prices.length || transCount == 0) return 0;
        
        //create key 
        String key = currentDay + "-" + canBuy + "-" + transCount;
        
        if(memo.containsKey(key)) 
            return memo.get(key);
            
       int ans = 0;
        
        
        if(canBuy==1)
        {   //there are two choice when buy option is available 1) buy 2 stay idle and move ahead
            int idle = maxProfit(prices, currentDay+1, canBuy, transCount);
            int buy =  -prices[currentDay]+ maxProfit(prices, currentDay+1,0, transCount);
            ans = Math.max(idle,buy);
        } else
        {   //there are two choice when sell option is available 1) sell 2) stay idle and move ahead
            int idle = maxProfit(prices, currentDay+1, canBuy, transCount);
            int sell =  prices[currentDay] + maxProfit(prices, currentDay+1,1, transCount-1);
            ans = Math.max(idle,sell);
        }
       
          
        memo.put(key, ans);
        return memo.get(key);
     }
}
