public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character,Integer> T = new HashMap<>();
        for(char c : t.toCharArray()){
            T.put(c,T.getOrDefault(c,0)+1);
        }
        int[] res = new int[2];
        res[0] = -1;
        int min = s.length();
        HashMap<Character,Integer> window = new HashMap<>();
        int have = 0, need = T.size();
        int i=0,j=0;
        while(j<s.length()){
            char curr = s.charAt(j);
            window.put(curr,window.getOrDefault(curr,0)+1);
            if(T.containsKey(curr) && window.get(curr).equals(T.get(curr))){
                have++;
            }
            
            while(have == need){
                if(j-i+1 <= min){
                    res[0] = i;
                    res[1] = j;
                    min = j-i+1;
                }
                char left = s.charAt(i);
                window.put(left,window.get(left)-1);
                if(T.containsKey(left) && window.get(left) < T.get(left)){
                    have--;
                }
                i++;
            }
            j++;
        }
        return res[0] == -1? "" : s.substring(res[0],res[1]+1);
    }
}
