class Solution {
    public int majorityElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        int[] countArray = new int[max+1];
        for(int i : nums){
            countArray[i]++;
        }
        int res = -1;
        int maxF = 0;
        for(int i=0; i<countArray.length; i++){
            if(countArray[i] > maxF){
                maxF = countArray[i];
                res = i;
            }
        }
        return res;
    }
}