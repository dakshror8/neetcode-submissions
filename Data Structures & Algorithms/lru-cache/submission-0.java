class LRUCache {
    private class Node{
        int key, value;
        Node prev, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    private int capacity;
    private HashMap<Integer,Node> cache;
    private Node left, right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    // left -> LRU, right -> MRU

    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    // insert at right
    private void insert(Node node){
        Node prev = this.right.prev;
        this.right.prev = node;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            this.remove(cache.get(key));
            this.insert(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            this.remove(cache.get(key));
        }
        Node node = new Node(key,value);
        this.insert(node);
        cache.put(key,node);

        if(cache.size() > this.capacity){
            Node lru = this.left.next;
            this.remove(lru);
            cache.remove(lru.key);
        }
    }
}
