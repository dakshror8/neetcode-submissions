class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int k, int v){
        this.key = k;
        this.val = v;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    int cap;
    Node right;
    Node left;
    Map<Integer, Node> cache;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.cache = new HashMap<>();
    }
    
    public void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        Node nxt = this.right;

        prev.next = node;
        nxt.prev = node;

        node.next = nxt;
        node.prev = prev;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if(cache.size() > cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}