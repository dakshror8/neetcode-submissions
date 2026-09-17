class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2:
            return False
        target = sum(nums) // 2
        dp = [[-1] * (target+1) for _ in range(len(nums)+1)]

        def dfs(i, target):
            if target == 0:
                return True
            if i >= len(nums) or target < 0:
                return False
            if dp[i][target] != -1:
                return dp[i][target]

            dp[i][target] = dfs(i+1, target-nums[i]) or dfs(i+1, target)

            return dp[i][target]
        
        return dfs(0,target)