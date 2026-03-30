class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> count1 = new HashMap<>();
        for(char c : s1.toCharArray()){
            count1.put(c,count1.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> count2 = new HashMap<>();
        int i=0,j=0;
        while(j < s2.length()){
            char curr = s2.charAt(j);
            count2.put(curr,count2.getOrDefault(curr,0)+1);

            if(j-i+1 == s1.length()){
                if(count1.equals(count2)){
                    return true;
                }
                else{
                    char left = s2.charAt(i);
                    count2.put(left,count2.get(left)-1);
                    if(count2.get(left) == 0){
                        count2.remove(left);
                    }
                    i++;
                }
            }
            j++;
        }
        return false;
    }
}
