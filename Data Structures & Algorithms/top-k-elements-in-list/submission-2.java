class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        // iterate the map to find max freq
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
            if(e.getValue() > max){
                max = e.getValue();
            }
        }

        List<Integer>[] bucket = new List[max+1];
        for(int i=0; i<bucket.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
            int index = e.getValue();
            bucket[index].add(e.getKey());
        }

        int[] res = new int[k];
        int j = 0;
        for(int i = bucket.length-1; i>=0; i--){
            List<Integer> l = bucket[i];
            for(int n : l){
                if(j == res.length){
                    return res;
                }
                res[j++] = n;
            }
        }
        return res;
    }
}
