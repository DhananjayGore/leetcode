import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/combination-sum-ii/
//level: medium
public class LC40_CombinationSum2 {

	Set<List<Integer>> list = new HashSet<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		Arrays.sort(candidates);
		// combinationSum2(candidates,target,new ArrayList<>(), 0);
		backtrack(new ArrayList<>(), candidates, target, 0);
		return new ArrayList(list);
	}

	private void backtrack(List<Integer> tempList, int[] cand, int remain, int start) {

		if (remain < 0)
			return; /** no solution */
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < cand.length; i++) {
				if (i > start && cand[i] == cand[i - 1])
					continue; /** skip duplicates */
				tempList.add(cand[i]);
				backtrack(tempList, cand, remain - cand[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
    
    //causing TLE
    /*
    public void combinationSum2(int[] c, int trgt, List<Integer> l, int idx){
        
        if(trgt == 0){
            list.add(new ArrayList(l));
            return;
        }
        
        if(trgt <= 0 || idx >= c.length) return;
        
        //ArrayList<Integer> temp_list = new ArrayList<>(l);
        l.add(c[idx]);
        
        combinationSum2(c,trgt-c[idx],l,idx+1);
        l.remove(l.size()-1);
        combinationSum2(c,trgt,l,idx+1);
        
    }*/
}
