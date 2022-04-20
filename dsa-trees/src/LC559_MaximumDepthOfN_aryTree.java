/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * @level : easy
 */
public class LC559_MaximumDepthOfN_aryTree {

	public int maxDepth(Node root) {

		if (root == null)
			return 0;

		int maxHeight = 0;
		for (Node currChild : root.children) {
			maxHeight = Math.max(maxHeight, maxDepth(currChild));
		}
		return 1 + maxHeight;
	}

}
