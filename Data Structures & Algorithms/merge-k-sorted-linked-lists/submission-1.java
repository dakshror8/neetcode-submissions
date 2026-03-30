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
/*
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

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(mergeList(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[mergedLists.size()]);
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }
}