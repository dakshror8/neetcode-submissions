class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp ,-1);
        return rec(nums, 0, dp);
    }
    int rec(int[] nums, int i, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1) return dp[i];

        
        
        return dp[i] = Math.max(rec(nums, i+1, dp), nums[i] + rec(nums, i+2, dp));
    }
}
