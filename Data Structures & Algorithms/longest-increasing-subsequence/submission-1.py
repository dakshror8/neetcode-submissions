class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [-1] * len(nums) 
        res = 0
        for i in range(len(nums)):
            res = max(res, self.dfs(nums, i, dp))
        return res
    
    def dfs(self, nums, i, dp):
        if i >= len(nums):
            return 0
        if dp[i] != -1:
            return dp[i]
        res = 1
        for j in range(i+1, len(nums)):
            curr_len= 1
            if nums[j] > nums[i]:
                curr_len += self.dfs(nums, j, dp)
                res = max(res, curr_len)
        dp[i] = res
        return res


            