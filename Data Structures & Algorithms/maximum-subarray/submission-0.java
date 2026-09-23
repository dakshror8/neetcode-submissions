class Solution {
    public int maxSubArray(int[] nums) {
        int max_sub = nums[0], cur_max = 0;
        for(int num : nums){
            if(cur_max < 0){
                cur_max = 0;
            }
            cur_max += num;
            max_sub = Math.max(max_sub, cur_max);
        }
        return max_sub;
    }
}
