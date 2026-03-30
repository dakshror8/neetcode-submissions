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
        if(k == 0){
            return null;
        }
        for(int i=1; i<k; i++){
            lists[i] = mergeTwoSortedLists(lists[i-1],lists[i]);
        }
        return lists[k-1];
    }
    ListNode mergeTwoSortedLists(ListNode h1, ListNode h2){
        ListNode head = null, tail = null;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                if(head == null){
                    head = h1;
                    tail = h1;
                }
                else{
                    tail.next = h1;
                    tail = tail.next;
                }
                h1 = h1.next;
            }
            else{
                if(head == null){
                    head = h2;
                    tail = h2;
                }
                else{
                    tail.next = h2;
                    tail = tail.next;
                }
                h2 = h2.next;
            }
        }

        if(h1 != null){
            tail.next = h1;
        }

        if(h2 != null){
            tail.next = h2;
        }

        return head;
    }
}
