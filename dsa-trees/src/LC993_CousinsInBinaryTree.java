/**
 * 
 */

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/cousins-in-binary-tree/
 * @level : easy
 */
public class LC993_CousinsInBinaryTree {
	public boolean isCousins(TreeNode root, int x, int y) {

		int[] parents = new int[2];
		int[] levels = new int[2];

		findParentAndLevel(root, new TreeNode(-1), 0, x, y, parents, levels);
		return parents[0] != parents[1] && levels[0] == levels[1];
	}

	private void findParentAndLevel(TreeNode root, TreeNode currParent, int currLevel, int x, int y, int[] parents,
			int[] levels) {

		if (root == null) {
			return;
		}

		if (root.val == x) {
			parents[0] = currParent.val;
			levels[0] = currLevel;
		}

		if (root.val == y) {
			parents[1] = currParent.val;
			levels[1] = currLevel;
		}

		findParentAndLevel(root.left, root, currLevel + 1, x, y, parents, levels);
		findParentAndLevel(root.right, root, currLevel + 1, x, y, parents, levels);
		return;
	}
}
