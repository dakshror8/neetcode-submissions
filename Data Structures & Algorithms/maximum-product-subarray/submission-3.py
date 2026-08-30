class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        curMax, curMin = 1, 1

        for n in nums:
            ''' We dont actually need this as 0 automatically breaks the subarray
            and res store max before it and if there is max after it
                         [2,   0,    8]
            [max,min] -> [2,2],[0,0],[8,0]
                res   =  [2,   2,    8],  at end res = 8   
            if n == 0:
                curMax, curMin = 1, 1
                continue
            '''
            
            tmp = n * curMax
            curMax = max(n * curMax, n * curMin, n)
            curMin = min(tmp, n * curMin, n)
            res = max(res, curMax)
        
        return res