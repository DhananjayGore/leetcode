import java.util.ArrayList;
import java.util.List;

/**
 * @author dhananjay 
 * link  : https://leetcode.com/problems/permutations/
 * level : medium
 */
public class LC46_Permutations {

List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
         permute(new ArrayList<>() , nums);
        return list;
    }
    
    public void permute(List<Integer> list, int[] nums){
        
        if(list.size()==nums.length){
            this.list.add(new ArrayList<>(list));
        }
        
        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])) continue;
            else{
                list.add(nums[i]);
                permute(list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
