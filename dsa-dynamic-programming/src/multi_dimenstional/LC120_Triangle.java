/**
 * 
 */
package multi_dimenstional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/triangle/
 * @level : medium
 */
public class LC120_Triangle {

public int minimumTotal(List<List<Integer>> triangle) {
        
        Map<String, Integer> dp = new HashMap<>();
        return minimumTotal(triangle, 0, 0, triangle.size(), dp);
    }
    
    //traingleIndex : index in triangle list to get the list at that level 
    //indexAtLevel : is the actual index you will use to get minimum of two values at that level(traingleIndex)
    private int minimumTotal(List<List<Integer>> triangle, int traingleIndex, int indexAtLevel, int size, Map<String, Integer> dp){
        
        //when traingleIndex is greater that size of triangle means we used all the levels
        if(size <= traingleIndex) return 0;
        
        //initialize both the path with maximum values as we may not get chance to follow the path at any level
        //because of out of index
        int path1 = 10001;
        int path2 = 10001;
        
        // create a key for a level of traingle which can uniquely define a min value
        String key = traingleIndex+"_"+indexAtLevel;
        if(dp.containsKey(key)) return dp.get(key);
        
        List<Integer> listAtLevel = triangle.get(traingleIndex);
        int sizeAtLevel = listAtLevel.size();
        
        if(indexAtLevel < sizeAtLevel){
            //path1 will include value at indexAtLevel to min sum
            path1 = listAtLevel.get(indexAtLevel) + minimumTotal(triangle, traingleIndex+1,indexAtLevel, size, dp);
        }
        if(indexAtLevel+1 < sizeAtLevel){
            //path2 will include value at indexAtLevel+1 to min sum
            path2 = listAtLevel.get(indexAtLevel+1) + minimumTotal(triangle, traingleIndex+1,indexAtLevel+1, size, dp);
        }
        
        //memorize min sum path
        dp.put(key, Math.min(path2, path1));
        //return
        return dp.get(key);
    }
}
