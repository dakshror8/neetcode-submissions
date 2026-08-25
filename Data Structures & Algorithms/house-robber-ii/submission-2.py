class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        def rob_linear(houses):
            dp = [-1] * len(houses)

            def dfs(i):
                if i >= len(houses):
                    return 0
                if dp[i] != -1:
                    return dp[i]

                dp[i] = max(dfs(i+1), houses[i] + dfs(i+2))
                return dp[i]
        
            return dfs(0)
        
        return max(rob_linear(nums[:-1]), rob_linear(nums[1:]))
