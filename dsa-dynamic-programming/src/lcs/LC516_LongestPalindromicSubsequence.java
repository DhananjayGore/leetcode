/**
 * 
 */
package lcs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/longest-palindromic-subsequence/
 * @level : medium
 */
public class LC516_LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		Map<String, Integer> dp = new HashMap<>();
		return lcs(s, new StringBuilder(s).reverse().toString(), 0, 0, s.length(), dp);
	}

	private int lcs(String s, String sRev, int i, int j, int m, Map<String, Integer> dp) {
		// here i is to iterate over s1 string and j over srev string
		if (i >= m || j >= m)
			return 0;

		String key = i + "_" + j;
		if (dp.containsKey(key))
			return dp.get(key);

		int ans = 0;
		if (s.charAt(i) == sRev.charAt(j))
			// if char at i and j in s1 and sRev resp. is common(same) obviously its going
			// to contribute in longest common
			// subsequence
			ans = 1 + lcs(s, sRev, i + 1, j + 1, m, dp);
		else {
			// if char at i and j in s1 and sRev resp. are not same then either we will go
			// with considering i and j individually
			// and will take the max hwatever we will get
			int a = lcs(s, sRev, i, j + 1, m, dp);
			int b = lcs(s, sRev, i + 1, j, m, dp);
			ans = Math.max(a, b);
		}

		dp.put(key, ans);
		return dp.get(key);
	}
}
