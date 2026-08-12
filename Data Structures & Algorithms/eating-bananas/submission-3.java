class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1;
        for(int p : piles){
            r = Math.max(r, p);
        }
        int ans = Integer.MAX_VALUE;
        while(l < r){
            int mid = l + (r-l)/2;
            
            int time = calTime(piles, mid);
            if(time <= h){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    int calTime(int[] arr, int k){
        int t = 0;
        for(int p : arr){
            t += (p+k-1)/k;
        }
        return t;
    }
}
