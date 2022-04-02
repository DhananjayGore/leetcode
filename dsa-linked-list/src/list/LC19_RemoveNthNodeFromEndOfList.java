package list;

/**
 * @author dhananjay 
 * @link  :	https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @level : medium
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LC19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while(i < n){
            fast = fast.next;
            i++;
        }
        if(fast == null) return head.next;
        while(fast.next!= null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}