/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/merge-two-binary-trees/
 * @level : easy
 */
public class LC617_MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return merge(root1, root2);
	}

	private TreeNode merge(TreeNode t1, TreeNode t2) {

		if (t1 == null)
			return t2;

		if (t2 == null)
			return t1;

		TreeNode newNode = new TreeNode(t1.val + t2.val);
		newNode.left = merge(t1.left, t2.left);
		newNode.right = merge(t1.right, t2.right);
		return newNode;
	}
}
