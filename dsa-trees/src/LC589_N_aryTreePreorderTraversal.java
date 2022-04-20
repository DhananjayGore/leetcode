import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * @level : easy
 */
public class LC589_N_aryTreePreorderTraversal {
	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<>();
		preorder(root, list);
		return list;
	}

	public void preorder(Node root, List<Integer> list) {
		if (root == null)
			return;

		list.add(root.val);
		List<Node> childrens = root.children;

		for (Node currChild : childrens) {
			preorder(currChild, list);
		}
		return;
	}
}
