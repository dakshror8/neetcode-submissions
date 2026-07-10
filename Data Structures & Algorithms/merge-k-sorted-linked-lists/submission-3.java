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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) return null;
        // if(k == 1) return lists[0];
        for(int i=1; i<k; i++){
            lists[i] = mergeTwoLists(lists[i-1], lists[i]);
        }
        return lists[lists.length-1];
    }
    ListNode mergeTwoLists(ListNode h1, ListNode h2){
        ListNode output = null;
        ListNode tail = output;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                if(output == null){
                    output = h1;
                    tail = output;
                }
                else{
                    tail.next = h1;
                    tail = tail.next;
                }
                h1 = h1.next;
            }
            else{
                if(output == null){
                    output = h2;
                    tail = output;
                }
                else{
                    tail.next = h2;
                    tail = tail.next;
                }
                h2 = h2.next;
            }
        }

        while(h1 != null){
            if(output == null){
                    output = h1;
                    tail = output;
                }
                else{
                    tail.next = h1;
                    tail = tail.next;
                }
                h1 = h1.next;
        }

        while(h2 != null){
            if(output == null){
                    output = h2;
                    tail = output;
                }
                else{
                    tail.next = h2;
                    tail = tail.next;
                }
                h2 = h2.next;
        }

        return output;
    }
}
