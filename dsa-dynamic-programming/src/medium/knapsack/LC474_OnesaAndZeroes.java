/**
 * 
 */
package medium.knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/ones-and-zeroes/
 * @level : medium
 */
public class LC474_OnesaAndZeroes {
	public int findMaxForm(String[] strs, int m, int n) {

		Map<String, Integer> dp = new HashMap<>();
		return helper(strs, 0, m, n, dp);
	}

	private int helper(String[] s, int currentIndex, int zeros, int ones, Map<String, Integer> dp) {

		if (currentIndex == s.length || (zeros == 0 && ones == 0))
			return 0;

		String key = currentIndex + "_" + zeros + "_" + ones;
		if (dp.containsKey(key))
			return dp.get(key);

		int zeroCount = countZeros(s[currentIndex]);
		int oneCount = s[currentIndex].length() - zeroCount;

		int include = 0;
		if (ones >= oneCount && zeros >= zeroCount) {
			include = 1 + helper(s, currentIndex + 1, zeros - zeroCount, ones - oneCount, dp);
		}
		int exclude = helper(s, currentIndex + 1, zeros, ones, dp);

		dp.put(key, Math.max(include, exclude));
		return dp.get(key);
	}

	private int countZeros(String str) {
		int zero = 0;
		for (char c : str.toCharArray()) {
			if (c == '0')
				zero++;
		}
		return zero;
	}
}
