class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = [defaultdict(int) for _ in range(len(nums)+1)]
        dp[0][0] = 1 #(0 elements, 0 sum) -> 1 way
        # 1 way to make 0 sum with 0 elements

        for i in range(len(nums)):
            for curr_sum, count in dp[i].items():
                dp[i+1][curr_sum - nums[i]] += count
                dp[i+1][curr_sum + nums[i]] += count

        return dp[len(nums)][target]

        memo = {}

        def dfs(target , i):
            if i == len(nums) and target == 0:
                return 1;
            if i >= len(nums):
                return 0
            if (target, i) in memo:
                return memo[(target, i)]

            memo[(target, i)] = dfs(target + nums[i], i+1) + dfs(target - nums[i], i+1)

            return memo[(target, i)]

        return dfs(target, 0)