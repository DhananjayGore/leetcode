import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/contiguous-array/
 * @level : medium
 */
public class LC525_ContiguousArray {
	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int len = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + (nums[i] == 1 ? 1 : -1);
			if (map.containsKey(sum)) {
				len = Math.max(len, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return len;
	}
}
