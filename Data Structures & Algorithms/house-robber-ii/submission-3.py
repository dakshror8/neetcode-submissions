class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        def rob_linear(houses):
            n = len(houses)

            rob2, rob1 = houses[n-1], max(houses[n-2], houses[n-1])

            for i in range(n-3, -1, -1):
                new_rob = max(rob1, houses[i] + rob2)
                rob2 = rob1
                rob1 = new_rob
        
            return rob1
        
        return max(rob_linear(nums[:-1]), rob_linear(nums[1:]))
