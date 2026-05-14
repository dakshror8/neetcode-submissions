class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();

        int maxLen = 0;
        int l=0, r=0;
        int maxFreq = 0;
        while(r < s.length()){
            
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            
            maxFreq = Math.max(maxFreq, window.get(s.charAt(r)));

            int extraCharCount = (r-l+1) - (maxFreq);
            while(extraCharCount > k){
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                // if(map.get(leftChar) == 0){
                //     map.remove(leftChar);
                // }
                for(Map.Entry<Character, Integer> e : window.entrySet()){
                    maxFreq = Math.max(maxFreq, e.getValue());
                }
                l++;
                extraCharCount = (r-l+1) - maxFreq;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;

        }
        return maxLen;
    }
}
