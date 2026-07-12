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
        ListNode pointer = head;
        List<ListNode> list = new ArrayList<>();

        while(true){
            ListNode kthNode = getKthNode(pointer, k);
            if(kthNode == null) break;

            ListNode t = kthNode.next;
            kthNode.next = null;

            list.add(reverse(pointer));

            pointer = t;
        }

        if(pointer != null){
            list.add(pointer);
        }

        for(int i=0; i<list.size()-1; i++){
            ListNode tail = list.get(i);
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = list.get(i+1);
        }

        return list.get(0);
    }

    ListNode getKthNode(ListNode head, int k){
        while(head != null && k>1){
            head = head.next;
            k--;
        }
        return head;
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        
        while(head != null){
            ListNode t = head.next;
            head.next = prev;
            prev = head;
            head = t;
        }
        return prev;
    }
}
