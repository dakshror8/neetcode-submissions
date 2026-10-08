class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0], cur_sum = 0;
        for(int num : nums){
            cur_sum += num;
            max_sum = Math.max(max_sum, cur_sum);
            if(cur_sum < 0){
                cur_sum = 0;
            }
        }
        return max_sum;
    }
}
