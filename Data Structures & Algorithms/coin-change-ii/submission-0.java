class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length+1][amount+1];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return unboundedKnapsack(coins, amount, 0);
    }  
    private int unboundedKnapsack(int[] coins, int amount, int i){
        if(i >= coins.length){
            return 0;
        }
        if(amount == 0){
            return 1;
        }

        if(dp[i][amount] != -1) return dp[i][amount];
        if(coins[i] <= amount){
            return dp[i][amount] = unboundedKnapsack(coins, amount-coins[i], i) 
                            + unboundedKnapsack(coins, amount, i+1);
        }
        else{
            return dp[i][amount] = unboundedKnapsack(coins, amount, i+1);
        }
    }
}
