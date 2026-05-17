class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        output = []
        # decreasing monotomic queue
        # double end queue because we need to add and remove at both end in O(1)
        q = collections.deque() # index
        l = 0
        for r in range(len(nums)):
            # remove smaller val from right
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            
            # add curr val to deque
            q.append(r)

            # before new window remove left val
            if l > q[0]:
                q.popleft()
            
            # valid window
            if r-l+1 == k:
                output.append(nums[q[0]])
                l += 1
        
        return output
