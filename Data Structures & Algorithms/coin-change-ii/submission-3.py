class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = {}

        def dfs(i, amount):
            if amount == 0:
                return 1
            if i >= len(coins) or amount < 0:
                return 0
            if (i, amount) in dp:
                return dp[(i, amount)]

            take = dfs(i, amount - coins[i])

            skip = dfs(i+1, amount)

            dp[(i, amount)] = take + skip
            return dp[(i, amount)]
           
        return dfs(0, amount)