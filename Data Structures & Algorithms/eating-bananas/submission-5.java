class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=Integer.MIN_VALUE;
        for(int n: piles){
            r = Math.max(r, n);
        }

        while(l < r){
            int k = l + (r-l)/2;
            int time = countTime(piles, k);
            if(time > h){
                l = k+1;
            }
            else{
                r = k;
            }
        }
        return r;
    }
    int countTime(int[] piles, int k){
        int time = 0;
        for(int pile: piles){
            time += (pile + k -1)/k;
        }
        return time;
    }
}
