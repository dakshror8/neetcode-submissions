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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;

            if(head == null){
                head = node;
                tail = head;
            }
            else{
                tail.next = node;
                tail = node;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = l1.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;

            if(head == null){
                head = node;
                tail = head;
            }
            else{
                tail.next = node;
                tail = node;
            }
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;

            if(head == null){
                head = node;
                tail = head;
            }
            else{
                tail.next = node;
                tail = node;
            }
            l2 = l2.next;
        }
        if(carry > 0){
            ListNode node = new ListNode(carry);
            tail.next = node;
            tail = node;
        }
        return head;
    }
}
