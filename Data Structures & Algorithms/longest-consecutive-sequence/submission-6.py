class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        res = 0
        for i in range(len(nums)):
            curLen = 1
            if nums[i]-1 not in numSet:
                cur = nums[i]
                while cur+1 in numSet:
                    curLen += 1
                    cur = cur+1
            res = max(res,curLen)
        return res