/**
 * 
 */
package multi_dimenstional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * @level : medium
 */
public class LC1155_NumberOfDiceRollsWithTargetSum {
	int count = 0;
	int MOD = 1000000007;

	public int numRollsToTarget(int n, int k, int target) {
		Map<String, Integer> dp = new HashMap<>();
		return numRollsToTarget(n, k, target, dp);
	}

	private int numRollsToTarget(int noOfDice, int faces, int target, Map<String, Integer> dp) {
		//once target is zero and noOfDice is also zero , that means we have used all the dices and through 
		//which we reached target as zero(sum of selection of dices == target)
		if (target == 0 && noOfDice == 0)
			return 1;

		// if target is not zero and no more dice left to roll and select any face
		if (noOfDice == 0)
			return 0;

		//create key out of noOfDices and target remaining
		String key = noOfDice + "_" + target;
		if (dp.containsKey(key))
			return dp.get(key);

		int sum = 0;
		// so for current dice(noOFDice) , we will have faces no. of selection for 
		for (int face = 1; face <= faces; face++) {
			sum += numRollsToTarget(noOfDice - 1, faces, target - face, dp);
			sum = sum % MOD;
		}
		dp.put(key, sum);
		return dp.get(key);
	}
}
