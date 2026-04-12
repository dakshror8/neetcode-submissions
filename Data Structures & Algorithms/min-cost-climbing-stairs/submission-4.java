class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        for(int i=n-3; i>=0; i--){
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }
    // int dfs(int[] cost, int i){
    //     if(i >= cost.length) return 0;

    //     if(dp[i] != -1) return dp[i];

    //     return dp[i] = cost[i] + Math.min(dfs(cost, i+1), dfs(cost, i+2));
    // }
}
