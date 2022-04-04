/**
 * 
 */
package stone_game_variations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/stone-game/
 * @level : medium
 */
public class LC877_StoneGame {
	int half;
	Map<String, Integer> dp = new HashMap<>();

	public boolean stoneGame(int[] piles) {
		half = piles.length / 2;
		int total = 0;
		for (int i = 0; i < piles.length; i++)
			total += piles[i];

		int alice = helper(piles, 0, piles.length - 1, 0);
		int bob = total - alice;
		if (alice > bob)
			return true;
		return false;
	}

	private int helper(int[] piles, int start, int end, int count) {

		if (count > half || start >= end)
			return 0;

		String key = start + "_" + end + "_" + count;
		if (dp.containsKey(key))
			return dp.get(key);

		int takeStart = piles[start] + helper(piles, start + 1, end, count + 1);
		int takeEnd = piles[end] + helper(piles, start, end - 1, count + 1);

		dp.put(key, Math.max(takeStart, takeEnd));
		return dp.get(key);
	}
}
