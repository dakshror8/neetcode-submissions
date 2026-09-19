class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {}
        def dfs(i, target):
            if target == 0 and i == len(nums):
                return 1
            if i == len(nums):
                return 0
            if (i, target) in dp:
                return dp[(i, target)]
            
            dp[(i, target)] = dfs(i+1, target - nums[i]) + dfs(i+1, target + nums[i])
            return dp[(i, target)]
        
        return dfs(0, target)