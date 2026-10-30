class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [-1] * len(s)

        def dfs(i):
            if i == len(s):
                return 1
            if s[i] == '0':
                return 0
            if dp[i] != -1:
                return dp[i]
            
            count = 0
            count += dfs(i+1)
        
            if i < len(s)-1:
                if s[i] == '2' and '0' <= s[i+1] < '7':
                    count += dfs(i+2)
                elif s[i] == '1':
                    count += dfs(i+2)
            
            dp[i] = count
            return count

        return dfs(0)