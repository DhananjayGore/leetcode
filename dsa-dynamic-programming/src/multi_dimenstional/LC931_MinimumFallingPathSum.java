/**
 * 
 */
package multi_dimenstional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/minimum-falling-path-sum/
 * @level : medium
 */
public class LC931_MinimumFallingPathSum {
	
public int minFallingPathSum(int[][] matrix) {
        
        int ans =1000000001;
        Map<String, Integer> dp = new HashMap<>();
        for(int colIndex = 0; colIndex < matrix[0].length; colIndex++){
            //we have to calculate min path sum , which can be stating from any column of zero'th row
            int minPath = minFallingPathSum(matrix, 0, colIndex, matrix.length, matrix[0].length, dp);
            ans = Math.min(ans, minPath);
        }
        return ans;
    }
    
    
    private int minFallingPathSum(int[][] matrix, int rowIndex, int colIndex, int totalRow, int totalCol, Map<String, Integer> dp){
        
    // if colIndex is out of bound (0 to totalCol) , we will return max value as we are not following valid path
    if(colIndex < 0 || colIndex >= totalCol) return 100001;
        
        String key = rowIndex+"_"+colIndex;
        if(dp.containsKey(key)) return dp.get(key);
    if(rowIndex == totalRow-1){
        return matrix[rowIndex][colIndex];
    }
        // choice one - rowIndex+1, colIndex-1
        int left = matrix[rowIndex][colIndex] + minFallingPathSum(matrix, rowIndex+1, colIndex-1, totalRow, totalCol, dp);
        // choice two - rowIndex+1, colIndex
        int below = matrix[rowIndex][colIndex] + minFallingPathSum(matrix, rowIndex+1, colIndex, totalRow, totalCol, dp);
        // choice three - rowIndex+1, colIndex+1
        int right = matrix[rowIndex][colIndex] + minFallingPathSum(matrix, rowIndex+1, colIndex+1, totalRow, totalCol, dp);
        
        //calculate min path sum from left, below, right
        int minPathSum = Math.min(left, Math.min(below, right));
        //memorize
        dp.put(key, minPathSum);
        return dp.get(key);
    }
}
