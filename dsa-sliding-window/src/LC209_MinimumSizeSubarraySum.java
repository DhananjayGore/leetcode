/**
 * 
 */


/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/minimum-size-subarray-sum/
 * @level : medium
 */
public class LC209_MinimumSizeSubarraySum {

	public int minSubArrayLen(int target, int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

		// the approach we are going to use is sliding window and prefix sum
		// how ? - so we will loop through the array and start two pointers say
		// left and right (right to increase window size and left to shrink window)
		// sum the elements until we reach to sum >= target and increase window size
		while (right < a.length) {
			sum += a[right++];

			// we will start shrinking our window size until our sum is less than target
			while (sum >= target) {
				// calculate min window size
				min = Math.min(min, right - left);
				sum -= a[left++];
			}
		}
		// return
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
