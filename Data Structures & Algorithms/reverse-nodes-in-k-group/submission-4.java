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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true){
            ListNode kthNode = getKthNode(groupPrev, k);
            if(kthNode == null) break;
            ListNode groupNext = kthNode.next;

            // reversing
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while(curr != groupNext){
                ListNode t = curr.next;
                curr.next = prev;
                prev = curr;
                curr = t;
            } 

            ListNode t = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = t;
        }
        return dummy.next;
    }
    ListNode getKthNode(ListNode head, int k){
        while(head != null && k >0){
            head = head.next;
            k--;
        }
        return head;
    }
}
