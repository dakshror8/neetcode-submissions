class MyHashSet {
    ArrayList<Integer> list;
    
    public MyHashSet() {
        list = new ArrayList<>();
    }
    
    public void add(int key) {
        list.add(key);
    }
    
    public void remove(int key) {
        if(this.contains(key)){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                if(list.get(i) == key){
                    continue;
                }
                temp.add(list.get(i));
            }
            list = temp;
        }
    }
    
    public boolean contains(int key) {
        for(int i=0; i<list.size();i++){
            if(list.get(i) == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */