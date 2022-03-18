/**
 * 
 */
package medium.knapsack;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/2-keys-keyboard/
 * @level : medium
 */
public class LC650_2KeysKeyboard {

	public int minSteps(int n) {
		if (n == 1)
			return 0;
		return 1 + helper(n, 1, 1);
	}

	private int helper(int neededA, int onScreenA, int copiedA) {
		if (neededA == onScreenA) {
			return 0;
		}

		if (neededA < onScreenA)
			return 1001;

		int copy = Integer.MAX_VALUE;
		int paste = Integer.MAX_VALUE;
		// paste
		paste = 1 + helper(neededA, onScreenA + copiedA, copiedA);
		// copy
		if (onScreenA != copiedA)
			copy = 1 + helper(neededA, onScreenA, onScreenA);

		return Math.min(copy, paste);
	}

}
