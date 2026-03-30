class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles){
            max = Math.max(max,i);
        }
        int l = 1, r = max;
        int res = 0;
        while(l <= r){
            int k = l + (r-l)/2;
            int hours_needed = 0;
            for(int i : piles){
                hours_needed += ceil(i,k);
            }
            if(hours_needed > h){
                l = k+1;
            }
            else{
                res = k;
                r = k-1;
            }
        }
        return res;
    }
    int ceil(int n, int k){
        return (n+k-1)/k;
    }
}
