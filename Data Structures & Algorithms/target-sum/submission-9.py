class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        memo = {}

        def dfs(target , i):
            if i == len(nums) and target == 0:
                return 1;
            if i >= len(nums):
                return 0
            if (target, i) in memo:
                return memo[(target, i)]

            res = dfs(target + nums[i], i+1)
            res += dfs(target - nums[i], i+1)

            memo[(target, i)] = res
            return res

        return dfs(target, 0)