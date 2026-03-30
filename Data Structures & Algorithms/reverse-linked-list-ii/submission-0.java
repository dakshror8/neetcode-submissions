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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode left = head;
        for(int i=1; i<l; i++){
            prev = left;
            left = left.next;
        }
        ListNode p = null;
        ListNode curr = left;
        int i = 1;
        while(i <= r-l+1){
            ListNode temp = curr.next;
            curr.next = p;
            p = curr;
            curr = temp;
            i++;
        }
        
        prev.next = p;
        left.next = curr;
        return dummy.next;
    }
}