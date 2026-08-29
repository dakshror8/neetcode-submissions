class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1] * (amount + 1)
        
        def dfs(amount):
            if amount == 0:
                return 0
            if amount < 0:
                return float('inf')
            if dp[amount] != -1:
                return dp[amount]
            minCoins = float('inf')
            for c in coins:
                res = dfs(amount-c)
                if res != float('inf'):
                    minCoins = min(minCoins, 1+res)
            
            dp[amount] = minCoins
            return minCoins
        
        res = dfs(amount)
        return res if res <= amount else -1
    