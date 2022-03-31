/**
 * 
 */
package unbounded_knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://practice.geeksforgeeks.org/problems/rod-cutting0840/1/
 * @level : easy
 */
public class GFG_RodCutting {

	 public int cutRod(int price[], int length) {
	        return helper(price, length, 0, new HashMap<String, Integer>());
	    }
	    
	    private int helper(int[] price, int length, int currIndex, Map<String, Integer> memo){
	        
	    	//return zero beacuse we reached length upto zero and found one possible way to cut rod
	        if(length == 0) return 0;
	        
	        //we cant proceed further as currentIndex exceed prices array
	        if(currIndex >= price.length) return 0;
	        
	        //create key for length and currIndex
	        String currentKey = length+"#"+currIndex;
	        
	        //return the currentKey which is memorized already
	        if(memo.containsKey(currentKey)) return memo.get(currentKey);
	        
	        
	        int consider =0;
	        //consider the rod cutting if we can cut , or its possible yo cut with the current length(currIndex +1)
	        if(currIndex+1 <= length){
	           consider = price[currIndex]+helper(price,length-(currIndex+1), currIndex, memo); 
	        }
	        //dont consider the current length and proceed further without cutting
	        int notConsider =helper(price, length, currIndex+1, memo);
	        
	        //memorize the solution
	        memo.put(currentKey, Math.max(consider, notConsider));
	        
	        //return currentKey
	        return memo.get(currentKey);
	    }
}
