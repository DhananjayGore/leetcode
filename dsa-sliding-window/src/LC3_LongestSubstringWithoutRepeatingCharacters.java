import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//level : medium

public class LC3_LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> map = new HashMap<>();

		int left = 0, count = 0;
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);

			if (map.containsKey(c)) // here note the left ptr
				left = Math.max(left, map.get(c) + 1); // abba,right=3 then left cant be set as left+1 hence max
			count = Math.max(count, right - left + 1);
			map.put(c, right);
		}
		return count;
	}
}
