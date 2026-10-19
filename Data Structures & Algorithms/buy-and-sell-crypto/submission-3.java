class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int res = 0;
        for(int r=l+1; r<prices.length; r++){
            res = Math.max(res, prices[r] - prices[l]);
            if(prices[r] <= prices[l]){
                l = r;
            }
        }
        return res;
    }
}
