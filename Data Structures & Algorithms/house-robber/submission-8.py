class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        one = nums[n-1]
        two = max(one, nums[n-2])
        for i in range(n-3, -1, -1):
            nums[i] = max(nums[i] + one, two)
            one = two
            two = nums[i]
        return max(one, two)