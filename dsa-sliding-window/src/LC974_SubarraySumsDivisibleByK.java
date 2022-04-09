import java.util.HashMap;

/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * @level : medium
 */
public class LC974_SubarraySumsDivisibleByK {

	public int subarraysDivByK(int[] nums, int k) {
		int count = 0, sum = 0, remainder = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(remainder, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			remainder = ((sum % k) + k) % k;
			if (map.containsKey(remainder))
				count += map.get(remainder);
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);
		}
		return count;
	}
}
