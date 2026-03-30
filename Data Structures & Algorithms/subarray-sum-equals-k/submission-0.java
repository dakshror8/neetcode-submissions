class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, res = 0;
        for(int j=0; j<nums.length; j++){
            sum += nums[j];
            int prefixSum = sum - k;
            if(map.containsKey(prefixSum)){
                res += map.get(prefixSum);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}