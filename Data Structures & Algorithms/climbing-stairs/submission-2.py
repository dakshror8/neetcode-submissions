class Solution:
    def climbStairs(self, n: int) -> int:
        one = two = 1
        for i in range(n-2, -1, -1):
            tmp = one + two
            two = one
            one = tmp
        return one