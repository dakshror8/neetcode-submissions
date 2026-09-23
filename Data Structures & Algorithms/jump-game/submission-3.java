class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }
    boolean dfs(int[] nums, int i, int[] dp){
        if(i == nums.length-1){
            return true;
        }
        if(nums[i] == 0){
            return false;
        }
        if(dp[i] != -1){
            return dp[i] == 1 ? true : false;
        }
        int end = Math.min(nums.length-1, i + nums[i]);
        for(int j=i+1; j<=end; j++){
            if(dfs(nums, j, dp)){
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}
