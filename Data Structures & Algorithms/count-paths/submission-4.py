class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * (n) for _ in range(m)]
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]
        dp = {}
        def dfs(i, j):
            if i < 0 or i >= m or j < 0 or j >= n:
                return 0
            if i == m-1 and j == n-1:
                return 1
            if (i, j) in dp:
                return dp[(i, j)]
            
            dp[(i, j)] = dfs(i, j+1) + dfs(i+1, j)
            return dp[(i, j)]

        return dfs(0,0)