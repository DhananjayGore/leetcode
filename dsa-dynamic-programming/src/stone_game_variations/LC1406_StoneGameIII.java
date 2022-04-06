/**
 * 
 */
package stone_game_variations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/stone-game-iii/
 * @level : hard
 */
public class LC1406_StoneGameIII {
	public String stoneGameIII(int[] stoneValue) {

		Map<String, Integer> memo = new HashMap<>();
		int alice = helper(stoneValue, 0, memo);
		System.out.println(alice);
		if (alice < 0)
			return "Bob";
		if (alice > 0)
			return "Alice";
		return "Tie";
	}

	private int helper(int[] stones, int currIndex, Map<String, Integer> memo) {

		if (currIndex >= stones.length)
			return 0;

		String key = currIndex + "";
		if (memo.containsKey(key))
			return memo.get(key);

		int ans = Integer.MIN_VALUE;
		ans = Math.max(ans, stones[currIndex] - helper(stones, currIndex + 1, memo));
		if (currIndex + 1 < stones.length)
			ans = Math.max(ans, stones[currIndex] + stones[currIndex + 1] - helper(stones, currIndex + 2, memo));
		if (currIndex + 2 < stones.length)
			ans = Math.max(ans, stones[currIndex] + stones[currIndex + 1] + stones[currIndex + 2]
					- helper(stones, currIndex + 3, memo));

		memo.put(key, ans);
		return ans;
	}
}
