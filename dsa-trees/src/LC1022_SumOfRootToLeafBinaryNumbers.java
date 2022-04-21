/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 * @level : easy
 */
public class LC1022_SumOfRootToLeafBinaryNumbers {
	public int sumRootToLeaf(TreeNode root) {
		return dfsSum(root, 0);
	}

	public int dfsSum(TreeNode root, int val) {
		if (root == null)
			return 0;
		val = val * 2 + root.val;
		return root.left == root.right ? val : dfsSum(root.left, val) + dfsSum(root.right, val);
	}
}
