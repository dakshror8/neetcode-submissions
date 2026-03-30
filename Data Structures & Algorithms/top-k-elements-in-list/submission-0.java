class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int num : nums){
        map.put(num,map.getOrDefault(num,0)+1);
       }
       List<Integer>[] bucketArr = new List[nums.length+1];
       for(int i=0; i<bucketArr.length; i++){
        bucketArr[i] = new ArrayList<>();
       }
       for(Map.Entry<Integer,Integer> e : map.entrySet()){
        bucketArr[e.getValue()].add(e.getKey());
       }
       int[] res = new int[k];
       int index = 0;
       for(int i=bucketArr.length-1; i>0; i--){
        for(int j=0; j<bucketArr[i].size() && index < k; j++){
            res[index] = bucketArr[i].get(j);
            index++;
            if(index == k){
                return res;
            }
        }
       }
        return res;
    }
}
