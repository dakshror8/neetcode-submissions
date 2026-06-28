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

        if(len == n) return head.next;

        int index = len - n;
        ListNode prev = null;
        ListNode curr = head;   
        for(int i=0; i<index; i++){
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        return head;
    }
}
