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
    public void reorderList(ListNode head) {
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        ListNode temp = head;
        for(int i=0; i<len/2; i++){
            temp = temp.next;
        }
        ListNode headForReverse = temp.next;
        temp.next = null;
        ListNode reversedHead = reverseList(headForReverse);
    
        // insertions
        temp = head;
        while(reversedHead != null){
            ListNode temp2 = temp.next;
            temp.next = reversedHead;
            ListNode temp3 = reversedHead.next;
            reversedHead.next = temp2;
            reversedHead = temp3;
            temp = temp2;
        }
    }
    ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        return prev;
    }
}
