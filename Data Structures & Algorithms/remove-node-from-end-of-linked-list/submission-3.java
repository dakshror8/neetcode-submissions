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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        if(len == n){
            return head.next;
        } 

        n = len - n;
        int i=0;
        ListNode prev = null;
        ListNode curr = head;
        while(i < n && curr != null){
            prev = curr;
            curr = curr.next;
            i++;
        }

        prev.next = curr.next;
        curr.next = null;
        return head;
    }
}
