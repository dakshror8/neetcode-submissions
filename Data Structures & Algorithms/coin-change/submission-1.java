class Solution {
    int[][] t;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        t = new int[n+1][amount+1];

        // Initialisation 
        // 1st row and col
        for(int i=0; i<n+1; i++){
            for(int j=0; j<amount+1; j++){
                if(j == 0){
                    t[i][j] = 0;
                }
                if(i == 0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }
            }
        }
        
        // 2nd row init
        for(int j=1; j<amount+1; j++){
            if(j % coins[0] == 0){
                t[1][j] = j / coins[0];
            }
            else{
                t[1][j] = Integer.MAX_VALUE-1;
            }
        }

        // code
        for(int i=2; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(1 + t[i][j-coins[i-1]],
                                t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][amount] == Integer.MAX_VALUE-1 ? -1 : t[n][amount];
    }
}
