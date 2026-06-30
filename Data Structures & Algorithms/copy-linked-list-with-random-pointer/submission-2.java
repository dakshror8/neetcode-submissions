/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();
        
        
        Node newHead = null;
        Node newTail = newHead;
        Node t = head;
        while(t != null){
            Node newNode = new Node(t.val);
            if(newHead == null){
                newHead = newNode;
            }
    
            map.put(t, newNode);
            t = t.next;
        }
        t = head;
        while(t != null){
            map.get(t).next = map.get(t.next);
            map.get(t).random = map.get(t.random);
            t = t.next;
        }
        return newHead;
    }
}
