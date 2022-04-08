import java.util.HashSet;

/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/sum-of-square-numbers/
 * @level : medium
 */
public class LC633_SumOfSquareNumbers {

	public boolean judgeSquareSum(int c) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i <= Math.sqrt(c); i++) {
			set.add(i * i);
			if (set.contains(c - i * i)) {
				return true;
			}
		}
		return false;
	}
}
