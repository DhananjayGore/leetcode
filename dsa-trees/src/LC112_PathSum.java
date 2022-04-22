/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/path-sum/
 * @level : easy
 */
public class LC112_PathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && targetSum - root.val == 0)
			return true;

		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}
}
