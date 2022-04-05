/**
 * 
 */
package stone_game_variations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/stone-game-ii/
 * @level : medium
 */
public class LC1140_StoneGameII {

	public int stoneGameII(int[] piles) {
		Map<String, Integer> dp = new HashMap<>();

		int sum = 0;
		for (int i = 0; i < piles.length; i++)
			sum += piles[i];

		int totalPiles = piles.length;

		int value = helper(piles, 0, 1, totalPiles, dp);
		return (sum + value) / 2;
	}

	private int helper(int[] piles, int index, int M, int totalPiles, Map<String, Integer> dp) {

		if (index >= totalPiles)
			return 0;

		String key = index + "_" + M;
		if (dp.containsKey(key))
			return dp.get(key);

		int alice = Integer.MIN_VALUE;
		int tempSum = 0;
		for (int i = 0; i < 2 * M; i++) {
			if (!(index + i < totalPiles))
				break;
			tempSum += piles[index + i];
			alice = Math.max(alice, tempSum - helper(piles, index + i + 1, Math.max(i + 1, M), totalPiles, dp));
		}
		dp.put(key, alice);
		return alice;
	}
}
