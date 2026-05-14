class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        int l=0, r=0;
        while(r < prices.length){
            if(prices[r] < prices[l]){
                l = r;
            }
            max = Math.max(max, prices[r] - prices[l]);
            r++;
        }

        return max;
    }
}
