import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/longest-common-subsequence/
 * @level : Hard
 */

// time complexity : O(m x n)
// space complexity : O(m x n) here minimum length of the string
public class LC1143_LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {

		Map<String, Integer> dp = new HashMap<>();
		return lcs(text1, text2, 0, 0, text1.length(), text2.length(), dp);
	}

	private int lcs(String s1, String s2, int i, int j, int m, int n, Map<String, Integer> dp) {
		// here i is to iterate over s1 string and j over s2 string
		if (i >= m || j >= n)
			return 0;

		String key = i + "_" + j;
		if (dp.containsKey(key))
			return dp.get(key);

		int ans = 0;
		if (s1.charAt(i) == s2.charAt(j))
			// if char at i and j in s1 and s2 resp. is common(same) obviously its going to
			// contribute in longest common
			// subsequence
			ans = 1 + lcs(s1, s2, i + 1, j + 1, m, n, dp);
		else {
			// if char at i and j in s1 and s2 resp. are not same then either we will go
			// with considering i and j individually
			// and will take the max hwatever we will get
			int a = lcs(s1, s2, i, j + 1, m, n, dp);
			int b = lcs(s1, s2, i + 1, j, m, n, dp);
			ans = Math.max(a, b);
		}

		dp.put(key, ans);
		return dp.get(key);
	}
}
