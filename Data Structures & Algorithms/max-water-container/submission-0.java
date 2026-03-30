class Solution {
    public int maxArea(int[] heights) {
        int maxAns = 0;
        int l = 0;
        int r = heights.length-1;
        while(l < r){
            int area = Math.min(heights[l],heights[r]) * (r-l);
            if(area > maxAns){
                maxAns = area;
            }
            if(heights[l] < heights[r]){
                l++;
            }
            else if(heights[l] > heights[r]){
                r--;
            }else{
                r--;
            }
        }
        return maxAns;
    }
}
