class Solution {
    // int[][] dp;
    // public int change(int amount, int[] coins) {
    //     dp = new int[coins.length+1][amount+1];
    //     for(int[] i : dp){
    //         Arrays.fill(i, -1);
    //     }
    //     return unboundedKnapsack(coins, amount, 0);
    // }  
    // private int unboundedKnapsack(int[] coins, int amount, int i){
    //     if(i >= coins.length){
    //         return 0;
    //     }
    //     if(amount == 0){
    //         return 1;
    //     }

    //     if(dp[i][amount] != -1) return dp[i][amount];
    //     if(coins[i] <= amount){
    //         return dp[i][amount] = unboundedKnapsack(coins, amount-coins[i], i) 
    //                         + unboundedKnapsack(coins, amount, i+1);
    //     }
    //     else{
    //         return dp[i][amount] = unboundedKnapsack(coins, amount, i+1);
    //     }
    // }

    int[][] t;
    public int change(int amount, int[] coins){
        t = new int[coins.length+1][amount+1];
        return topDown(coins, amount);
    }
    private int topDown(int[] coins, int amount){
        int n = coins.length;
        
        // Initialisation
        for(int i=0; i<n+1; i++){
            for(int j=0; j<amount+1; j++){
                if(j == 0){
                    t[i][j] = 1;
                }
                if(i == 0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                if(coins[i-1] <= j){
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][amount];
    }
}
