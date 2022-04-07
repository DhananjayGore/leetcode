import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author dhananjay
 * @link :
 *       https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1#
 * @level : easy
 */
public class GFG_CountDistinctElementsInEveryWindow {

	public static ArrayList<Integer> countDistinct(int a[], int n, int k) {
		int right = 0;
		int left = 0;
		// int count=0;
		ArrayList<Integer> al = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (; right < n; right++) {

			if (map.containsKey(a[right])) {
				map.put(a[right], map.get(a[right]) + 1);
				// count++;
			} else {
				map.put(a[right], 1);
				// count++;
			}

			if (right - left + 1 == k) {
				al.add(map.size());
				map.put(a[left], map.get(a[left]) - 1);
				if (map.get(a[left]) == 0) {
					map.remove(a[left]);
				}
				// count--;
				left++;
			}
		}
		return al;
	}
}
