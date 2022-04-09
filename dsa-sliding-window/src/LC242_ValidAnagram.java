import java.util.Arrays;

/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/valid-anagram/
 * @level : easy
 */
public class LC242_ValidAnagram {
	public boolean isAnagram(String s, String t) {
		char sc[] = s.toCharArray();
		char tc[] = t.toCharArray();

		Arrays.sort(sc);
		Arrays.sort(tc);
		boolean f = true;
		if (sc.length != tc.length) {
			return false;
		} else {
			for (int i = 0; i < sc.length; i++) {
				if (sc[i] != tc[i]) {
					f = false;
					break;
				}
			}
		}
		return f;
	}
}
