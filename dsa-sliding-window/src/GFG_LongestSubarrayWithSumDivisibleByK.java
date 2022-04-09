import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author dhananjay
 * @link :
 *       https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1/
 * @level : medium
 */
public class GFG_LongestSubarrayWithSumDivisibleByK {

	int longSubarrWthSumDivByK(int a[], int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			int rem = ((sum % k) + k) % k;
			if (!map.containsKey(rem))
				map.put(rem, i);
			else {
				int len = i - map.get(rem);
				max = Math.max(max, len);
			}
		}
		return max;
	}
}
