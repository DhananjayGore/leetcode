/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 * @level : medium
 */
public class LC1497_CheckIfArrayPairsAreDivisibleByK {

	public boolean canArrange(int[] arr, int k) {
		int memo[] = new int[k];

		for (int curr : arr) {
			int v = ((curr % k) + k) % k;
			memo[v] += 1;
		}

		for (int i = 0; i <= k / 2; i++) {
			if (i == 0) {
				if (memo[i] % 2 != 0)
					return false;
			} else {
				int y = k - i;
				if (memo[i] != memo[y])
					return false;
			}
		}
		return true;
	}
}
