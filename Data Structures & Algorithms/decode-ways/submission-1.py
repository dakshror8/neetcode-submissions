class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [-1] * (len(s)+1)
        def dfs(i):
            if i == len(s):
                return 1
            if s[i] == '0':
                return 0
            if dp[i] != -1:
                return dp[i]
            dp[i] = dfs(i+1)
            if i < len(s) - 1:
                if (s[i] == '1' or (s[i] == '2' and s[i+1] < '7')):
                    dp[i] += dfs(i+2)
            
            return dp[i]
             
        return dfs(0)