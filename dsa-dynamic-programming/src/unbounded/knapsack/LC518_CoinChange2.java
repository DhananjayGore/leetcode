/**
 * 
 */
package unbounded.knapsack;

import java.util.HashMap;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/coin-change-2/
 * @level : medium
 */
public class LC518_CoinChange2 {

	public int change(int amount, int[] coins) {
        HashMap<String, Integer> dp = new HashMap<>();
      return helper(amount, coins, 0, dp);
    }
    
    private int helper(int amount, int coins[], int currIndex,HashMap<String, Integer> dp){
        if(amount == 0) return 1;
        
        if(currIndex == coins.length) return 0;
        
        String key = currIndex+"-"+amount;
        if(dp.containsKey(key)) return dp.get(key);
        
        int incl =0;
        if(amount >= coins[currIndex]){
            incl = helper(amount-coins[currIndex], coins, currIndex, dp);
        }
        int dont_incl = helper(amount, coins, currIndex+1, dp);
        dp.put(key, incl+dont_incl);
        return dp.get(key);
    }
}
