class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        dp = [[-1] * (m) for _ in range(n)]

        def dfs(i, j):
            if dp[i][j] != -1:
                return dp[i][j]
            
            cur_res = 1

            del_row = [-1,0,1,0]
            del_col = [0,-1,0,1]
            for k in range(0, 4):
                new_row = i + del_row[k]
                new_col = j + del_col[k]
                if 0 <= new_row < n and 0 <= new_col < m:
                    if matrix[new_row][new_col] > matrix[i][j]:
                        cur_res = max(cur_res, 1 + dfs(new_row, new_col))
            
            dp[i][j] = cur_res
            return cur_res
        
        res = 0
        for i in range(n):
            for j in range(m):
                res = max(res, dfs(i, j))
        
        return res
