/**
 * 
 */
package binary_search_trees;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @level : medium
 */
public class LC1008_ConstructBinarySearchTreeFromPreorderTraversal {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return arrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode arrayToBST(int[] nums, int start, int end) {

		if (start > end)
			return null;

		int mid = start + (end - start) / 2;
		TreeNode newNode = new TreeNode(nums[mid], null, null);

		newNode.left = arrayToBST(nums, start, mid - 1);
		newNode.right = arrayToBST(nums, mid + 1, end);

		return newNode;
	}

}
