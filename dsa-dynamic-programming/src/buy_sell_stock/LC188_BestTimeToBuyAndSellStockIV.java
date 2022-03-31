package buy_sell_stock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @level : hard
 */
public class LC188_BestTimeToBuyAndSellStockIV {
	
public int maxProfit(int k, int[] prices) {
        
        Map<String, Integer> memo = new HashMap<>();
        return helper(prices, 0, 2*k,true, memo);
    }
    
    
    private int helper(int[] prices, int currentIndex, int totalTransactionLimit, boolean canBuy, Map<String, Integer> memo){
        //when you don't have days to proceed or transaction limit is zero return from here
        if(currentIndex == prices.length || totalTransactionLimit == 0) return 0;
        
        //create key
        String currentKey = currentIndex+"#"+totalTransactionLimit+"#"+canBuy;
        //return ans for current key which is memorized in prev steps
        if(memo.containsKey(currentKey)) return memo.get(currentKey);
        
        int ans =0;
        if(canBuy){
            //choice 1) canBuy == true , so you are allowed to buy stock
            int buy = -1*prices[currentIndex] + helper(prices, currentIndex+1, totalTransactionLimit-1, false, memo);
            //choice 2) we can skip the buy for current value 
            int idle = helper(prices, currentIndex+1, totalTransactionLimit, canBuy, memo);
            //calculate max of two choices
            ans = Math.max(idle, buy);
        }   
        else{
            //choice 1) canBuy == false , so you can sell the stock
            int sell = 1*prices[currentIndex] + helper(prices, currentIndex+1, totalTransactionLimit-1, true, memo);
            //choice 2) we can stay idle and select not to sell already bought stock at current price
            int idle = helper(prices, currentIndex+1, totalTransactionLimit, canBuy, memo);
            //calculate max of two choices
            ans = Math.max(idle, sell);
        }
            
        // memorize the ans 
        memo.put(currentKey, ans);
        //return
        return memo.get(currentKey);
    }
}
