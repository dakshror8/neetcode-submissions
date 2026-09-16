class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = -int(1e9)
        cur_min = 1
        cur_max = 1
        for num in nums:
            tmp = cur_min
            cur_min = min(num, num*cur_min, num*cur_max)
            cur_max = max(num, num*tmp, num*cur_max)
            res = max(res, cur_max)
        
        return res