class Solution {
    public int climbStairs(int n) {
        int one = 1, two = 1;
        for(int i=n-2; i>=0; i--){
            int t = one + two;
            two = one;
            one = t;
        }
        return one;
    }
}
