class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = {} # key = (amount, index), value = #unique ways

        def dfs(amount, i):
            if i >= len(coins) or amount < 0:
                return 0
            if amount == 0:
                return 1
            if (amount, i) in dp:
                return dp[(amount, i)]

            count = 0
            for j in range(i, len(coins)):
                count += dfs(amount - coins[j], j)
            
            dp[(amount, i)] = count
            return count
        
        return dfs(amount, 0)