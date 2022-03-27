package buy.sell.stock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @level : easy
 */
public class LC121_BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
        //only one transaction allowed i.e.(buy and sell)
        int transLimit=1;
        
        return maxProfit(prices, 0, true, transLimit, new HashMap<>());
    }
    
    private int maxProfit(int[] prices, int currentDay, boolean canBuy,int transLimit,  Map<String, Integer> memo){
        
    	//currentday is out of total avaliable days and buy/sell price on that day or transLimit is zero
        if(currentDay == prices.length || transLimit==0) return 0;
        
        //String currentKey with currentDay, transLimit and canBuy(boolean)
        String currentKey = currentDay+"#"+transLimit+"#"+canBuy;
        if(memo.containsKey(currentKey)) return memo.get(currentKey); 
        
        //initalize profit with zero
        int profit=0;
        if(canBuy){
        	//we can buy as canBuy==true , so include the price as an investment hence we are subtracting
            int buy = maxProfit(prices, currentDay+1, false, transLimit, memo) - prices[currentDay];
            // we also have choice to skip and stay idle and move ahead
            int idle = maxProfit(prices, currentDay+1, true, transLimit, memo);
            
            profit = Math.max(buy, idle);
        }
        else{
        	//here we can sell as canBuy=false, so inlcude price on current day as selling price
            int sell = maxProfit(prices, currentDay+1, true, transLimit-1, memo) + prices[currentDay];
            //we can stay idle here as we have choice to sell or idle
            int idle = maxProfit(prices, currentDay+1, false, transLimit, memo);
            
            profit = Math.max(sell, idle);
        }
        
        //memorize the profit we are able to generate for current step
        memo.put(currentKey, profit);
        
        //return
        return memo.get(currentKey);
    }
}
