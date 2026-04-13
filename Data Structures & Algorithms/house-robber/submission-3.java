class Solution {
    // int[] dp;
    // public int rob(int[] nums) {
    //     dp = new int[nums.length+1];
    //     Arrays.fill(dp, -1);
    //     return dfs(nums,0);
    // }
    // private int dfs(int[] nums, int i){
    //     if(i >= nums.length){
    //         return 0;
    //     }
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }
    //     return dp[i] = Math.max(nums[i]+dfs(nums, i+2), dfs(nums,i+1));
    // }


    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        nums[0] = nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
        }
        return nums[nums.length-1];
    }
}
