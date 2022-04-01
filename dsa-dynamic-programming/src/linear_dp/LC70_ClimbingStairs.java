/**
 * 
 */
package linear_dp;

import java.util.HashMap;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/climbing-stairs/
 * @level : easy
 */
public class LC70_ClimbingStairs {

    HashMap<Integer, Integer> dp = new HashMap<>();
    
    public int climbStairs(int n) {
        return totalWays(0,n);
    }
    
    private int totalWays(int currStair, int targetStair){
        
        if(currStair == targetStair) return 1;
        if(currStair > targetStair) return 0;
        
        int currentKey = currStair;
        if(dp.containsKey(currentKey))return dp.get(currentKey);
        
        int one_jump= totalWays(currStair+1, targetStair); 
        int two_jump= totalWays(currStair+2, targetStair);
        
        dp.put(currentKey, one_jump+two_jump);
        
        return one_jump+two_jump;
    }
}
