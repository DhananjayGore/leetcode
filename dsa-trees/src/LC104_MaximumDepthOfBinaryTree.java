/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @level : easy
 */
public class LC104_MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		int left = 1 + maxDepth(root.left);
		int right = 1 + maxDepth(root.right);
		return Math.max(left, right);
	}
}
