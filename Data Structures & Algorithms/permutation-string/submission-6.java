class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        Map<Character, Integer> s1map = new HashMap<>();

        for(char c : s1.toCharArray()){
            s1map.put(c, s1map.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> window = new HashMap<>();

        int l=0, r=0;
        while(r < s2.length()){
            window.put(s2.charAt(r), window.getOrDefault(s2.charAt(r), 0) + 1);

            if(r-l+1 > s1.length()){
                //shrink
                window.put(s2.charAt(l), window.get(s2.charAt(l)) - 1);
                if(window.get(s2.charAt(l)) == 0){
                    window.remove(s2.charAt(l));
                }
                l++;
            }

            if(s1map.equals(window)){
                return true;
            }

            r++;
        }
        return false;
    }
}
