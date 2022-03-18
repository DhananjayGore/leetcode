/**
 * 
 */
package medium.knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/partition-equal-subset-sum/
 * @level : medium
 */
public class LC416_PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {
	       
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        
        if(totalSum % 2 != 0) return false;
        
        return canPartition(nums,0, totalSum/2,0, new HashMap());
    }
    

    private boolean canPartition(int[] nums,int currIndex,int halfOfTotal, int currentSum, Map<String, Boolean> dp){
        
        if(currentSum == halfOfTotal) return true;
        
        if(currIndex >= nums.length) return false;
        
        String key =currIndex+"#"+currentSum;
        if(dp.containsKey(key)) return dp.get(key);
        
        boolean include = false;
        if(currentSum <= halfOfTotal){
            include = canPartition(nums,currIndex+1,halfOfTotal,currentSum+nums[currIndex], dp);
        }
        if(include){
            dp.put(key, include);
            return include;
        }
         boolean dont_include = canPartition(nums,currIndex+1,halfOfTotal,currentSum, dp);
        
        dp.put(key ,include || dont_include);
        return dp.get(key);
    }
}
