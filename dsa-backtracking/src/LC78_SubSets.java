import java.util.ArrayList;
import java.util.List;

/*
 https://leetcode.com/problems/subsets/
 level: medium
*/
public class LC78_SubSets {

	List<List<Integer>> b = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> a = new ArrayList<>();
		return subset(0, nums, a);
	}

	public List<List<Integer>> subset(int i, int nums[], List<Integer> a) {
		if (i == nums.length) {
			b.add(new ArrayList<>(a));
			return b;
		}
		a.add(nums[i]);

		subset(i + 1, nums, a);
		a.remove(a.size() - 1);

		subset(i + 1, nums, a);
		return b;
	}

}
