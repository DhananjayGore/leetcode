/**
 * 
 */
package easy;

import java.util.HashMap;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/n-th-tribonacci-number
 * @level : easy
 */
public class LC1137_NthTribonacciNumber {

	HashMap<Integer, Integer> dp = new HashMap<>();

	public int tribonacci(int n) {
		return helper(n);

	}

	public int helper(int n) {

		if (n <= 0)
			return 0;
		if (n < 2)
			return 1;

		int currKey = n;
		if (dp.containsKey(currKey))
			return dp.get(currKey);

		dp.put(currKey, helper(n - 1) + helper(n - 2) + helper(n - 3));

		return dp.get(currKey);
	}
}
