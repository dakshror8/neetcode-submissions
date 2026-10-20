class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        int maxF = 0;
        int l = 0;
        for(int r=0; r<s.length(); r++){
            char cur = s.charAt(r);
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            maxF = Math.max(maxF, count.get(cur));
            
            while(r-l+1 - maxF > k){
                char left = s.charAt(l);
                count.put(left, count.get(left) - 1);
                maxF = Math.max(maxF, count.get(left));
                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
