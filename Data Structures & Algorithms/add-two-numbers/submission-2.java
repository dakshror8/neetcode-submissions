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
        int carry = 0;
        ListNode res = null;
        ListNode tail = res;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 == null){
                sum = l2.val + carry;
            }
            else if(l2 == null){
                sum = l1.val + carry;
            }else{
                sum = l1.val + l2.val + carry;
            }
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            if(res == null){
                res = node;
                tail = res;
            }else{
                tail.next = node;
                tail = tail.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            
        }
        if(carry > 0){
            ListNode node = new ListNode(carry);
            tail.next = node;
            tail = tail.next;
        }
        tail.next = null;
        return res;
    }
    
}
