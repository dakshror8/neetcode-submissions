class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> count1 = new HashMap<>();
        for(char c : s1.toCharArray()){
            count1.put(c,count1.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> count2 = new HashMap<>();
        int l=0, r=0;
        while(r < s2.length()){
            count2.put(s2.charAt(r),count2.getOrDefault(s2.charAt(r),0)+1);

            if(r-l+1 == s1.length()){
                if(count2.equals(count1)){
                    return true;
                }
                count2.put(s2.charAt(l), count2.get(s2.charAt(l))-1);
                if(count2.get(s2.charAt(l)) == 0){
                    count2.remove(s2.charAt(l));
                }
                l++;
            }

            r++;
        }
        return false;
    }
}
