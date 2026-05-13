class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        ArrayList<Integer> possibleStarts = new ArrayList<>();
        for(int num : nums){
            if(!set.contains(num-1)){
                possibleStarts.add(num);
            }
        }

        int maxLen = 0;
        for(int start : possibleStarts){
            int len = 1;
            while(set.contains(start+1)){
                start = start+1;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
