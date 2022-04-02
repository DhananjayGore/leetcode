/**
 * 
 */
package list;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/swap-nodes-in-pairs/
 * @level : medium
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class LC24_SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode nextHead = head.next.next;

		ListNode temp = head;
		head = head.next;
		head.next = temp;

		head.next.next = nextHead;
		head.next.next = swapPairs(head.next.next);
		return head;

	}
}
