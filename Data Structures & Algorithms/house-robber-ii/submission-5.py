class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        return max(self.helper(nums[1:]), self.helper(nums[:-1])) 


    def helper(self, nums):
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        n = len(nums)
        dp = [-1] * n
        dp[n-1] = nums[n-1]
        dp[n-2] = max(nums[n-2], dp[n-1])

        for i in range(n-3, -1, -1):
            dp[i] = max(dp[i+1], nums[i] + dp[i+2])
        
        return dp[0]