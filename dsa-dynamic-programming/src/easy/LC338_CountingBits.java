/**
 * 
 */
package easy;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/counting-bits/
 * @level : easy
 */
public class LC338_CountingBits {

	public int[] countBits(int num) {
		int result[] = new int[num + 1];
		int offset = 1;
		for (int index = 1; index < num + 1; ++index) {
			if (offset * 2 == index) {
				offset *= 2;
			}
			result[index] = result[index - offset] + 1;
		}
		return result;
	}
}
