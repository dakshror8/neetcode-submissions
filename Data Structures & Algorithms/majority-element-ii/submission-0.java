class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        int[] hash = new int[max+1];
        for(int i = 0; i<nums.length; i++){
            hash[nums[i]]++;
        }
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<hash.length; i++){
            if(hash[i] > n/3){
                res.add(i);
            }
        }
        return res;
    }
}