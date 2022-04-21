/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/sum-of-left-leaves/
 * @level : easy
 */
public class LC404_SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}

	private int sumOfLeftLeaves(TreeNode root, Boolean onLeftLeave) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			return onLeftLeave ? root.val : 0;
		}

		int leftAns = sumOfLeftLeaves(root.left, true);
		int rightAns = sumOfLeftLeaves(root.right, false);

		return leftAns + rightAns;
	}
}
