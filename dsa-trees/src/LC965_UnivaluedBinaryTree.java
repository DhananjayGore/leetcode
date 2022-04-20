/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/univalued-binary-tree/
 * @level : easy
 */
public class LC965_UnivaluedBinaryTree {
	public boolean isUnivalTree(TreeNode root) {
		return isUnivalTree(root, root.val);
	}

	private boolean isUnivalTree(TreeNode root, int val) {

		if (root == null)
			return true;

		if (root.val != val)
			return false;

		return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);

	}
}
