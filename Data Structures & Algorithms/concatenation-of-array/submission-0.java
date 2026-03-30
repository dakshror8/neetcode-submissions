class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        int i=0;
        int index = 0;
        while(i < 2){
            for(int j=0; j<n; j++){
                ans[index] = nums[j];
                index++;
            }
            i++;
        }
        return ans;
    }
}