class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l = 0
        res = []

        for r in range(len(nums)):
            
            if(r-l+1 == k):
                # valid window -> find max
                res.append(self.maxi(nums, l, r))
                l += 1
            
            
        
        return res


    def maxi(self, nums, l, r):
        max_num = nums[l]
        i = l
        while i <= r:
            if(max_num < nums[i]):
                max_num = nums[i]
            i += 1
        return max_num