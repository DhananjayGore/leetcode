/**
 * 
 */
package unbounded.knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/coin-change/
 * @level : medium
 */
public class LC322_CoinChange {

public int coinChange(int[] coins, int amount) {
        
        
        if(amount == 0) return 0;
        int minCoins = helper(coins, amount, 0, new HashMap<>());
        if(minCoins > 10000)
            return -1;
        return minCoins;
    }
    
    private int helper(int[] coins, int amount, int currentIndex, Map<String, Integer> memo){
        
        //when amount is zero that mean whatever selection of coins we have choose is correct
        if(amount == 0) return 0;
        
        //when currentIndex is greater than length of coins array means we have wrong coin selection
        if(currentIndex >= coins.length) return 10001;
        
        
        //create a key which is unique based on currentItem and amount 
        String currentKey = currentIndex+"#"+amount;
        
        //we will return the value for the currentKey stored in prev steps which is memorized
        if(memo.containsKey(currentKey)) return memo.get(currentKey);
        
        //initialize consider with possible max value
        int consider = 10001;
        
        //consider the coin if current coin we are at, can be selected
        if(amount >= coins[currentIndex]){
            consider = 1 + helper(coins, amount-coins[currentIndex], currentIndex, memo);
        }
        // what if we dont want to co nsider and move ahead by skiiping the current coin 
        int dont_consider = helper(coins, amount, currentIndex+1, memo);
        
        //memorize the result for currentKey
        memo.put(currentKey,Math.min(consider, dont_consider));
        
        //return value calculated
        return memo.get(currentKey);
    }
}
