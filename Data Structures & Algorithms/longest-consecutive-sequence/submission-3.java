class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        int max = 0;
        for(int i=0; i<nums.length; i++){
            int length = 0;
            if(!set.contains(nums[i]-1)){
                length++;
                int start = nums[i];
                while(set.contains(start+1)){
                    length++;
                    start++;
                }
                if(length > max){
                    max = length;
                }
            }
        }
        return max;
    }
}
