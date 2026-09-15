class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1] * (amount+1)
        def dfs(amount):
            if amount == 0:
                return 0
            if dp[amount] != -1:
                return dp[amount]  
            
            dp[amount] = float("inf")
            for i in range(len(coins)):
                if amount >= coins[i]:
                    dp[amount] = min(dp[amount], 1 + dfs(amount - coins[i]))
            
            return dp[amount]

        min_coins = dfs(amount)
        return -1 if min_coins == float("inf") else min_coins