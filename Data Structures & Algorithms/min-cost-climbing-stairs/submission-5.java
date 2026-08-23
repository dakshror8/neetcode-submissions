class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = 0;
        int n_1 = cost[cost.length-1];
        for(int i=cost.length-2; i>=0; i--){
            int t = cost[i] + Math.min(n, n_1);
            n = n_1;
            n_1 = t;
        }
        return Math.min(n_1, n);
    }
}
