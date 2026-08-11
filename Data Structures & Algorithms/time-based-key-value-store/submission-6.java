class TimeMap {
    class Pair{
        String val;
        int timestamp;
        Pair(String v, int t){
            val = v;
            timestamp = t;
        }
    }
    Map<String, List<Pair>> ds;
    public TimeMap() {
        ds = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ds.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value,timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = ds.getOrDefault(key, new ArrayList<>());
        int l=0, r=list.size()-1;
        String ans = "";

        while(l<=r){
            int mid = (l+r)/2;
            int midTime = list.get(mid).timestamp;

            if(midTime <= timestamp){
                ans = list.get(mid).val;
                l = mid+1;
            }
            else if(midTime > timestamp){
                r = mid-1;
            }
        }
        return ans;
    }
}
