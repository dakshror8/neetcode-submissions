class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
       
        int i=0, j = 0;
        int maxF = 0;
        int res = 0;
        while(j < s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            
            // for(Map.Entry<Character,Integer> e : map.entrySet()){
            //     maxF = Math.max(maxF,e.getValue());
            // }
            maxF = Math.max(maxF, map.get(s.charAt(j)));
            
            if((j-i+1 - maxF) > k){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }

            res = Math.max(res,j-i+1);
            j++;
            
        }
        return res;
    }
}
