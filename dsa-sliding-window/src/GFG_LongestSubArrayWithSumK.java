import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author dhananjay
 * @link :
 *       https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1/
 * @level : medium
 */
public class GFG_LongestSubArrayWithSumK {

	public static int lenOfLongSubarr(int arr[], int N, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, max = 0;
		map.put(sum, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				int t = i - map.get(sum - k);
				if (max < t)
					max = t;
			}
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return max;
	}
}
