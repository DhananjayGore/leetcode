/**
 * 
 */
package linear_dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/min-cost-climbing-stairs/
 * @level : easy
 */
public class LC746_MinCostClimbingStairs {

	Map<Integer, Integer> dp = new HashMap();
    int len=0;
    public int minCostClimbingStairs(int[] cost) {
        
        len = cost.length;
        int startWithZero = minCostClimbingStairs(cost,0);
       // int startWithOne = minCostClimbingStairs(cost,1);
        //return Math.min(startWithZero, startWithOne);
        return startWithZero;
    }
    
    private int minCostClimbingStairs(int[] cost, int idx){
        
        if(idx == len){ // when we already reached the last stair we dont return 0
            return 0;
        }
        
        if(idx > len){ // steps we covered in prev. call are not reaching the last stair 
            return 1000;
        }
        
        int key = idx; // at each index we are having a min value of two choices 
        if(dp.containsKey(key)) return dp.get(key);
        
        int oneStep = minCostClimbingStairs(cost, idx+1) + cost[idx]; // call with one step
       // int twoStep = minCostClimbingStairs(cost, idx+2) + cost[idx]; // cal with two steps.
        int twoStep =0;
        if(idx+1 < len) twoStep = cost[idx+1] + minCostClimbingStairs(cost, idx+2);
        
        dp.put(key, Math.min(oneStep, twoStep)); // momorize the min of oneStep and twoStep
        return dp.get(key); 
    }
}
