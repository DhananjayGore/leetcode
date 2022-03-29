/**
 * 
 */
package multi_dimenstional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/palindrome-partitioning-ii/
 * @level : hard
 */
public class LC132_PalindromePartitioningII {
	public int minCut(String s) {
		Map<Integer, Integer> dp = new HashMap<>();
		return findMinimumCut(s, 0, s.length() - 1, dp);
	}

	public int findMinimumCut(String str, int start, int end, Map<Integer, Integer> dp) {
		// if string is already palindrome no need to partition and return
		if (isPalindrome(str, start, end))
			return 0;

		int key = start;
		if (dp.containsKey(key))
			return dp.get(key);

		// initialize with max
		int noOfWays = 100000;

		for (int i = start; i < end; i++) { // if our left part is palindrome the only we will be call recursive
											// function
			if (isPalindrome(str, start, i)) {
				int waysCalculated = 1 + findMinimumCut(str, i + 1, end, dp);
				noOfWays = Math.min(noOfWays, waysCalculated);
			}
		}

		// memorize min ways for the key
		dp.put(key, noOfWays);

		return dp.get(key);
	}

	// utility to check palindrome
	public boolean isPalindrome(String str, int start, int end) {
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;
	}
}
