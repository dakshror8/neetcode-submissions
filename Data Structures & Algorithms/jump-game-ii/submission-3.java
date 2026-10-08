class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }
    int dfs(int[] nums, int i, int[] dp){
        if(i == nums.length-1){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int res = nums.length;
        int end = Math.min(i + nums[i], nums.length-1);
        for(int j=i+1; j<=end; j++){
            res = Math.min(res, 1 + dfs(nums, j, dp));
        }
        dp[i] = res;
        return res;
    }
}
