/**
 * 
 */
package lcs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/edit-distance/
 * @level : hard
 */
// time complexity : O(word1.length() * word2.length())
// time complexity : O(word1.length() * word2.length())
public class LC72_EditDistance {

	class Solution {

		public int minDistance(String word1, String word2) {
			Map<String, Integer> dp = new HashMap<>();
			return minDistance(word1, word2, 0, 0, word1.length(), word2.length(), dp);
		}

		private int minDistance(String w1, String w2, int i, int j, int w1Len, int w2Len, Map<String, Integer> dp) {

			if (i >= w1Len)
				return w2Len - j;

			if (j >= w2Len)
				return w1Len - i;

			String key = i + "_" + j;
			if (dp.containsKey(key))
				return dp.get(key);

			int minOp = 1000001;
			if (w1.charAt(i) == w2.charAt(j)) {
				//you dont need to add any operation here as you got a matching char in string w2
				minOp = minDistance(w1, w2, i + 1, j + 1, w1Len, w2Len, dp);
			} else {
				//so what if char in w1 and w2 at indices i and j did not match --you have 3 options now explore yhose
				// insert -- you have inserted a char in w1 and you still at index i as no not moved and yet to process string from ith index
				int insert = minDistance(w1, w2, i, j + 1, w1Len, w2Len, dp);
				// you just deleted char in w1 so you moved to i+1 , as we are not considering ith char in w1 and still at jth in w2
				int delete = minDistance(w1, w2, i + 1, j, w1Len, w2Len, dp);
				//repaced means you updated char at index i in w1 with char at index j with w2
				int replace = minDistance(w1, w2, i + 1, j + 1, w1Len, w2Len, dp);
				minOp = 1 + Math.min(insert, Math.min(delete, replace));
			}

			dp.put(key, minOp);
			return minOp;
		}
	}
}
