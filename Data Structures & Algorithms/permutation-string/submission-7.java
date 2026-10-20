class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c : s1.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int l=0;
        for(int r=0; r<s2.length(); r++){
            char cur = s2.charAt(r);
            window.put(cur, window.getOrDefault(cur, 0) + 1);

            while(r-l+1 > s1.length()){
                char left =s2.charAt(l);
                window.put(left, window.get(left)-1);
                if(window.get(left) == 0){
                    window.remove(left);
                }
                l++;
            }

            if(r-l+1 == s1.length() && window.equals(charCount)){
                return true;
            }
        }
        return false;
    }
}
