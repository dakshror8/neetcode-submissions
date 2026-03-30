class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int currLen = 1;
        int max = 1;
        int lastEle = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == lastEle+1){
                currLen++;
                lastEle = nums[i];
                if(currLen > max){
                    max = currLen;
                }
            }
            else if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            else{
                currLen = 1;
                lastEle = nums[i];
            }
        }
        return max;
    }
}
