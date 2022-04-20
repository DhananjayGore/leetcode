import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/binary-tree-preorder-traversal/
 * @level : easy
 */
public class LC144_BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preorderTraversal(root, list);
		return list;
	}

	public void preorderTraversal(TreeNode root, List<Integer> list) {

		if (root == null)
			return;

		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
	}
}
