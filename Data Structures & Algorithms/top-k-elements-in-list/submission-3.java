class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            maxFreq = Math.max(maxFreq, e.getValue());
        }
        List<Integer>[] bucketArr = new List[maxFreq+1];
        for(int i=0; i<bucketArr.length; i++){
            bucketArr[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            bucketArr[e.getValue()].add(e.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i=bucketArr.length-1; i>=0; i--){
            for(int num : bucketArr[i]){
                if(idx == res.length) return res;
                res[idx] = num;
                idx++;
            }
        }

        return res;
    }
}
