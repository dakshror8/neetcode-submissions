class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int maxLen = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        for(int r=0; r<s.length(); r++){
            if(indexMap.containsKey(s.charAt(r))){
                l = Math.max(l, indexMap.get(s.charAt(r))+1);
            }

            indexMap.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
