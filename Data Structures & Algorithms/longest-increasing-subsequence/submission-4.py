class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [-1] * len(nums)

        def dfs(i):
            if i == len(nums):
                return 0
            if dp[i] != -1:
                return dp[i]
            res = 1
            for j in range(i+1, len(nums)):
                if nums[j] > nums[i]:
                    res = max(res, 1+dfs(j))
            dp[i] = res
            return res

        res = 0
        for i in range(len(nums)):
            res = max(res, dfs(i))
        
        return res